package tr.com.metamorfoz;

public class DmcSettingHandler
		implements
			org.drools.core.process.instance.WorkItemHandler {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(DmcSettingHandler.class);

	private final static String SERVICE_URI = "/DCM/ListDmcSettings";
	private final static Integer SOCKET_TIMEOUT = 3000;
	private final static Integer CONNECT_TIMEOUT = 3000;
	private final static Integer CONNECTION_REQUEST_TIMEOUT = 3000;

	public DmcSettingHandler() {
		super();
	}

	@Override
	public void executeWorkItem(org.kie.api.runtime.process.WorkItem workItem,
			org.kie.api.runtime.process.WorkItemManager manager) {

		logger.info(">> workItem:" + workItem);

		java.util.Map<String, Object> output = new java.util.HashMap<String, Object>();
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
							"application/json").addParameter("pUser", "admin")
					.addParameter("pPwd", "admin");

			java.net.URI requestUri = builder.getUri();
			org.apache.http.HttpHost httpHost = new org.apache.http.HttpHost(
					requestUri.getHost(), requestUri.getPort(),
					requestUri.getScheme());

			org.apache.http.client.methods.HttpUriRequest request = builder
					.build();
			org.apache.http.HttpResponse response = httpClient.execute(
					httpHost, request);

			com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

			String jsonInput = org.apache.http.util.EntityUtils
					.toString(response.getEntity());
			java.util.ArrayList<tr.com.metamorfoz.DmcSetting> list = objectMapper
					.readValue(
							jsonInput,
							new com.fasterxml.jackson.core.type.TypeReference<java.util.ArrayList<tr.com.metamorfoz.DmcSetting>>() {
							});

			for (DmcSetting dcm : list) {
				System.out.println(">>> dcm  " + dcm.toString());
			}
			output.put("dmcSettingList", list);

			logger.debug(">> ... CALLED REMOTE SERVICE : " + list.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(">> Unable to send", e);
			throw new RuntimeException(e);
		} finally {
			manager.completeWorkItem(workItem.getId(), output);
		}
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
