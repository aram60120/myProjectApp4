package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethodType;

public interface IOrderMethodService {
	Integer saveOrderMethod(OrderMethodType ob);
	public List<OrderMethodType> getAllOrderMethod();
	public void deleteOrderMethod(Integer id);
	OrderMethodType getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethodType ob);
	public List<Object[]> getOrderMethodModeCount();
}
