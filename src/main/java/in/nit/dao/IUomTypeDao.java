package in.nit.dao;




import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeDao {
	public Integer saveUom(UomType ob);
	List<UomType> getAllUomType();
	public void deleteUomType(Integer id);
	UomType getOneUomType(Integer id);
	void updateUomType(UomType ob);
	public List<Object[]> getuomTypeCount();
	
}
