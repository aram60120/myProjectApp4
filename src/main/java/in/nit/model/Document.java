package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="doctab")
public class Document {
@Id
@GeneratedValue(generator="increment")
@Column(name="fid")
private Integer fileId;
@Column(name="fname")
private String fileName;


@Column(name="fdata", length=10000000)
@Lob
private byte[] fileData;
public Document() {
	super();
}
}
