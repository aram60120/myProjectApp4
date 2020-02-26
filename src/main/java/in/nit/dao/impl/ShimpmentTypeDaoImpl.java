package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
@Repository
public class ShimpmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveShipmentType(ShipmentType ob) {

		return   (Integer)ht.save(ob);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {


		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType s=new ShipmentType();
		s.setShipId(id);
		ht.delete(s);
	}
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		System.out.println("daoimpl");
		return ht.get(ShipmentType.class, id);
		
	}
	
	
	@Override
	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
	}

}
