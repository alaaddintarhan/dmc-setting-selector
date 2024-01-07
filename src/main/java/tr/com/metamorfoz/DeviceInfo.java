package tr.com.metamorfoz;

import java.io.Serializable;

@org.kie.api.definition.type.Label("DeviceInfo")
public class DeviceInfo extends DeviceInfoDetail implements Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("imeiVendorName")
	private String imeiVendorName;
	@org.kie.api.definition.type.Label("imeiModelName")
	private String imeiModelName;
	@org.kie.api.definition.type.Label("isPhone")
	private boolean isPhone;
	@org.kie.api.definition.type.Label("omaSupport")
	private boolean omaSupport;
	@org.kie.api.definition.type.Label("tablet")
	private boolean tablet;
	@org.kie.api.definition.type.Label("smartphone")
	private boolean smartphone;

	public DeviceInfo() {
		super();
	}

	public DeviceInfo(String imeiVendorName, String imeiModelName,
			boolean isPhone, boolean omaSupport, boolean tablet,
			boolean smartphone) {
		super();
		this.imeiVendorName = imeiVendorName;
		this.imeiModelName = imeiModelName;
		this.isPhone = isPhone;
		this.omaSupport = omaSupport;
		this.tablet = tablet;
		this.smartphone = smartphone;
	}

	public String getImeiVendorName() {
		return imeiVendorName;
	}

	public void setImeiVendorName(String imeiVendorName) {
		this.imeiVendorName = imeiVendorName;
	}

	public String getImeiModelName() {
		return imeiModelName;
	}

	public void setImeiModelName(String imeiModelName) {
		this.imeiModelName = imeiModelName;
	}

	public boolean isPhone() {
		return isPhone;
	}

	public void setPhone(boolean phone) {
		isPhone = phone;
	}

	public boolean isOmaSupport() {
		return omaSupport;
	}

	public void setOmaSupport(boolean omaSupport) {
		this.omaSupport = omaSupport;
	}

	public boolean isTablet() {
		return tablet;
	}

	public void setTablet(boolean tablet) {
		this.tablet = tablet;
	}

	public boolean isSmartphone() {
		return smartphone;
	}

	public void setSmartphone(boolean smartphone) {
		this.smartphone = smartphone;
	}

}
