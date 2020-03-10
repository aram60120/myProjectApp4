package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethodType;
@Repository
public  class OrderMthodDaoImpl implements IOrderMethodDao{
	@Autowired
private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethodType ob) {
		
		return (Integer) ht.save(ob);
	}

	@Override
	public List<OrderMethodType> getAllOrderMethod() {
		return ht.loadAll(OrderMethodType.class);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
   OrderMethodType om=new OrderMethodType();
   om.setOrderId(id);
   ht.delete(om);
	}

	@Override
	public OrderMethodType getOneOrderMethod(Integer id) {

		return ht.get(OrderMethodType.class, id);
	}
	@Override
	public void updateOrderMethod(OrderMethodType ob) {
ht.update(ob);	
}
	@Override
		public List<Object[]> getOrderMethodModeCount() {
String hql="select orderMode, count(orderMode) from in.nit.model.OrderMethodType group by orderMode";
			return (List<Object[]>) ht.find(hql);
		}	
}
