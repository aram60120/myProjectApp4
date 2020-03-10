package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="parttab")
public class Part {

	public Part(Integer id) {
		super();
		this.id = id;
	}
	@Id
	@GeneratedValue
	private Integer id;
	private String partCode;
	private Double partLen;
	private Double partWid;
	private Double partHgt;
	private Double baseCost;
	private String baseCurrency;
	private String note;
	private UomType uomOb;
	
}
