package tr.com.metamorfoz;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class ClientRequest implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("msisdn")
	private java.lang.Integer msisdn;
	@org.kie.api.definition.type.Label("imsi")
	private java.lang.Integer imsi;
	@org.kie.api.definition.type.Label("imei")
	private java.lang.Integer imei;
	@org.kie.api.definition.type.Label("iccid")
	private java.lang.Integer iccid;

	public ClientRequest() {
	}

	public java.lang.Integer getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(java.lang.Integer msisdn) {
		this.msisdn = msisdn;
	}

	public java.lang.Integer getImsi() {
		return this.imsi;
	}

	public void setImsi(java.lang.Integer imsi) {
		this.imsi = imsi;
	}

	public java.lang.Integer getImei() {
		return this.imei;
	}

	public void setImei(java.lang.Integer imei) {
		this.imei = imei;
	}

	public java.lang.Integer getIccid() {
		return this.iccid;
	}

	public void setIccid(java.lang.Integer iccid) {
		this.iccid = iccid;
	}

	public ClientRequest(java.lang.Integer msisdn, java.lang.Integer imsi,
			java.lang.Integer imei, java.lang.Integer iccid) {
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.imei = imei;
		this.iccid = iccid;
	}

}