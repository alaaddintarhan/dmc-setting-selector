package tr.com.metamorfoz;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@org.kie.api.definition.type.Label("Handset")
public class Handset implements Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("id")
	private Integer id;
	@org.kie.api.definition.type.Label("insertDate")
	private Date insertDate;
	@org.kie.api.definition.type.Label("handsetImei")
	private List<String> handsetImei;

	public Handset() {
		super();
	}

	public Handset(Integer id, Date insertDate, List<String> handsetImei) {
		super();
		this.id = id;
		this.insertDate = insertDate;
		this.handsetImei = handsetImei;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public List<String> getHandsetImei() {
		return handsetImei;
	}

	public void setHandsetImei(List<String> handsetImei) {
		this.handsetImei = handsetImei;
	}

	@Override
	public String toString() {
		return "Handset [id=" + id + ", insertDate=" + insertDate
				+ ", handsetImei=" + handsetImei + "]";
	}

}
