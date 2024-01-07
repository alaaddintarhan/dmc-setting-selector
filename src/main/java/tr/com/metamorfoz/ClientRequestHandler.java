package tr.com.metamorfoz;

public class ClientRequestHandler
		implements
			org.drools.core.process.instance.WorkItemHandler {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(ClientRequestHandler.class);

	public ClientRequestHandler() {
		super();
	}

	@Override
	public void executeWorkItem(org.kie.api.runtime.process.WorkItem workItem,
			org.kie.api.runtime.process.WorkItemManager manager) {
		java.util.Map<String, Object> pars = workItem.getParameters();

		logger.info(">> workItem:" + workItem);

		check(workItem, "imei");
		check(workItem, "msisdn");
		check(workItem, "imsi");
		check(workItem, "iccid");

		manager.completeWorkItem(workItem.getId(),
				new java.util.HashMap<String, Object>());
	}

	private void check(org.kie.api.runtime.process.WorkItem workItem, String key) {
		Object val = workItem.getParameter(key);

		if (val == null || ((String) val).startsWith("#{"))
			throw new RuntimeException(key + " must not be null.");

		int i;
		try {
			i = Integer.valueOf((String) val);
		} catch (Exception e) {
			throw new RuntimeException(key + " must to be  numeric.");
		}
		if (i < 1)
			throw new RuntimeException(key + " must not be less than '1' .");

	}

	@Override
	public void abortWorkItem(org.kie.api.runtime.process.WorkItem workItem,
			org.kie.api.runtime.process.WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}
}
