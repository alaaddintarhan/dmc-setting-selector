package tr.com.metamorfoz;

public class DeviceInfoHandler
		implements
			org.drools.core.process.instance.WorkItemHandler {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(DeviceInfoHandler.class);

	private final static String SERVICE_URI = "/DCM/GetDeviceInfoByImei";
	private final static Integer SOCKET_TIMEOUT = 3000;
	private final static Integer CONNECT_TIMEOUT = 3000;
	private final static Integer CONNECTION_REQUEST_TIMEOUT = 3000;

	public DeviceInfoHandler() {
		super();
	}

	@Override
	public void executeWorkItem(org.kie.api.runtime.process.WorkItem workItem,
			org.kie.api.runtime.process.WorkItemManager manager) {

		logger.info(">> DeviceInfoHandler:" + workItem);

		java.util.Map<String, Object> output = new java.util.HashMap<String, Object>();

		String imei = (String) workItem.getParameter("imei");
		String host = getVal(workItem, "host");
		String uri = String.format("%s%s", host, SERVICE_URI);

		try {
			org.apache.http.client.config.RequestConfig config = org.apache.http.client.config.RequestConfig
					.custom()
					.setSocketTimeout(
							getOrDefult(
									workItem.getParameter("socket_timeout"),
									SOCKET_TIMEOUT))
					.setConnectTimeout(
							getOrDefult(
									workItem.getParameter("connect_timeout"),
									CONNECT_TIMEOUT))
					.setConnectionRequestTimeout(
							getOrDefult(
									workItem.getParameter("connection_request_timeout"),
									CONNECTION_REQUEST_TIMEOUT)).build();

			org.apache.http.client.HttpClient httpClient = org.apache.http.impl.client.HttpClientBuilder
					.create().setDefaultRequestConfig(config).build();

			org.apache.http.client.methods.RequestBuilder builder = org.apache.http.client.methods.RequestBuilder
					.get()
					.setUri(uri)
					.addHeader(org.apache.http.HttpHeaders.ACCEPT,
							"application/json")
					.addHeader(org.apache.http.HttpHeaders.CONTENT_TYPE,
							"application/json").addParameter("pUser", "jbpm")
					.addParameter("pPwd", "ş&klg86h4f5s2(o")
					.addParameter("pImei", imei);

			java.net.URI requestUri = builder.getUri();
			org.apache.http.HttpHost httpHost = new org.apache.http.HttpHost(
					requestUri.getHost(), requestUri.getPort(),
					requestUri.getScheme());
			org.apache.http.client.methods.HttpUriRequest request = builder
					.build();

			org.apache.http.HttpResponse response = httpClient.execute(
					httpHost, request);

			if (response.getEntity() == null
					|| response.getEntity().getContentLength() == 0)
				throw new RuntimeException("DeviceSetting Not Found.");
			else {

				String result = org.apache.http.util.EntityUtils
						.toString(response.getEntity());

				com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
				tr.com.metamorfoz.DeviceInfo deviceInfo = objectMapper
						.treeToValue(objectMapper.readTree(result),
								tr.com.metamorfoz.DeviceInfo.class);

				output.put("deviceInfo", deviceInfo);
			}

			logger.debug(">> ... CALLED REMOTE SERVICE :completed for imei:"
					+ imei);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DeviceInfoException : "
					+ e.getMessage());
		}

		manager.completeWorkItem(workItem.getId(), output);

	}

	@Override
	public void abortWorkItem(org.kie.api.runtime.process.WorkItem workItem,
			org.kie.api.runtime.process.WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}

	private int getOrDefult(Object obj, Integer defultVal) {
		try {
			return Integer.valueOf((String) obj);
		} catch (Exception e) {
			return defultVal;
		}

	}

	private String getVal(org.kie.api.runtime.process.WorkItem workItem,
			String key) {
		Object val = workItem.getParameter(key);

		if (val == null)
			throw new RuntimeException(key + " must not be null.");

		return (String) val;

	}
}