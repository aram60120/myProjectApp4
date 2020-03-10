
package in.nit.dao;


import java.util.List;

import in.nit.model.OrderMethodType;

public interface IOrderMethodDao {
	Integer saveOrderMethod(OrderMethodType ob);
	public List<OrderMethodType> getAllOrderMethod();
	void deleteOrderMethod(Integer id);
	OrderMethodType getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethodType ob);
	 public List<Object[]> getOrderMethodModeCount();

}
