package tr.com.metamorfoz;

import java.io.Serializable;
import java.util.Date;

@org.kie.api.definition.type.Label("DeviceInfoDetail")
public class DeviceInfoDetail implements Serializable {

	@org.kie.api.definition.type.Label("insertDate")
	private java.util.Date insertDate;
	@org.kie.api.definition.type.Label("handset")
	private Handset handset;

	public java.util.Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}

	public Handset getHandset() {
		return this.handset;
	}

	public void setHandset(Handset handset) {
		this.handset = handset;
	}

	public DeviceInfoDetail() {
	}

	public DeviceInfoDetail(java.util.Date insertDate,
			tr.com.metamorfoz.Handset handset) {
		this.insertDate = insertDate;
		this.handset = handset;
	}

}
