package tr.com.metamorfoz;

public class DmcSetting implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("imsi")
	private java.lang.String imsi;
	@org.kie.api.definition.type.Label("settingType")
	private java.lang.String settingType;
	@org.kie.api.definition.type.Label("settingSmsApdu")
	private java.lang.String settingSmsApdu;
	@org.kie.api.definition.type.Label("settingSmsXml")
	private java.lang.String settingSmsXml;
	@org.kie.api.definition.type.Label("channelId")
	private java.lang.Integer channelId;
	@org.kie.api.definition.type.Label("sender")
	private java.lang.String sender;

	public DmcSetting() {
	}

	public java.lang.String getImsi() {
		return this.imsi;
	}

	public void setImsi(java.lang.String imsi) {
		this.imsi = imsi;
	}

	public java.lang.String getSettingType() {
		return this.settingType;
	}

	public void setSettingType(java.lang.String settingType) {
		this.settingType = settingType;
	}

	public java.lang.String getSettingSmsApdu() {
		return this.settingSmsApdu;
	}

	public void setSettingSmsApdu(java.lang.String settingSmsApdu) {
		this.settingSmsApdu = settingSmsApdu;
	}

	public java.lang.String getSettingSmsXml() {
		return this.settingSmsXml;
	}

	public void setSettingSmsXml(java.lang.String settingSmsXml) {
		this.settingSmsXml = settingSmsXml;
	}

	public java.lang.Integer getChannelId() {
		return this.channelId;
	}

	public void setChannelId(java.lang.Integer channelId) {
		this.channelId = channelId;
	}

	public java.lang.String getSender() {
		return this.sender;
	}

	public void setSender(java.lang.String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "DmcSetting [imsi=" + imsi + ", settingType=" + settingType
				+ ", settingSmsApdu=" + settingSmsApdu + ", settingSmsXml="
				+ settingSmsXml + ", channelId=" + channelId + ", sender="
				+ sender + "]";
	}

	public DmcSetting(java.lang.String imsi, java.lang.String settingType,
			java.lang.String settingSmsApdu, java.lang.String settingSmsXml,
			java.lang.Integer channelId, java.lang.String sender) {
		this.imsi = imsi;
		this.settingType = settingType;
		this.settingSmsApdu = settingSmsApdu;
		this.settingSmsXml = settingSmsXml;
		this.channelId = channelId;
		this.sender = sender;
	}
}