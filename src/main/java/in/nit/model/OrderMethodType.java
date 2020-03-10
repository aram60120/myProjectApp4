package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Table(name="ordtab")
public class OrderMethodType {
@Id
@GeneratedValue(generator = "ordign")
@GenericGenerator(name="ordign",strategy = "increment")
@Column(name="ordid")
private Integer orderId;
@Column(name="ormd")
private String orderMode;
@Column(name="orcod")
private String orderCode;
@Column(name="ordtyp")
private String orderType;
@ElementCollection(fetch=FetchType.EAGER)
@CollectionTable(name="omtab",joinColumns = @JoinColumn(name="ordid"))
@Column(name="ordaccpt")
private List<String> orderAccept;
@Column(name="orddesc")
private String description;
}
