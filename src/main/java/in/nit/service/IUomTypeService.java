package in.nit.service;
import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeService {
 public Integer saveUom(UomType ob);
  public List<UomType> getAllUomType();
	public void deleteUomType(Integer id);
	public UomType getOneUomType(Integer id);
	public void updateUomType(UomType ob);
	public List<Object[]> getuomTypeCount();
}
