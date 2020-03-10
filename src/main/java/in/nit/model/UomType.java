package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="uomtap")
public class UomType {
	@Id
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1")
	@Column(name = "umid")
	private Integer uomId;
	@Column(name = "umtype")
	private String uomType;
	@Column(name = "ummod")
	private String uomModel;
	@Column(name = "udesc")
	private String description;

	public UomType() {
		super();
	}

	public UomType(Integer id) {
		super();
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UomType [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", description="
				+ description + "]";
	}

}
