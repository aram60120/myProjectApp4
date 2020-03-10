package in.nit.dao.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;
@Repository
public class UomTypeDaoImpl implements IUomTypeDao {
@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveUom(UomType ob) {
		System.out.println(" daoimpl");
		return (Integer) ht.save(ob);
	}
	
	  @Override
	  public List<UomType> getAllUomType() {
	  
	  return ht.loadAll(UomType.class);
	  }

	@Override
	public void deleteUomType(Integer id) {
  UomType u=new UomType();
  u.setUomId(id);
  ht.delete(u);
	}
	 @Override
		public UomType getOneUomType(Integer id) {
		 
			return ht.get(UomType.class, id);
		}
	 @Override
		public void updateUomType(UomType ob) {
 ht.update(ob);			
		}

	@Override
	public List<Object[]> getuomTypeCount() {
		String hql="select  uomType,count(uomType) from in.nit.model.UomType group by uomType";
		return (List<Object[]>) ht.find(hql);
	}
}
