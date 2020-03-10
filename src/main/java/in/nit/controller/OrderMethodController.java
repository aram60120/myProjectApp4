package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethodType;
import in.nit.service.IOrderMethodService;
import in.nit.util.OrderMethodTypeUtil;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdf;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
    private IOrderMethodService service;
	@Autowired
	private ServletContext context;
		@Autowired
	private OrderMethodTypeUtil util;
	@RequestMapping(value="/")
	public String showOrdermethod(Model model) {
		//OrderMethodType omb=new OrderMethodType();
		model.addAttribute("orderMethodType",new OrderMethodType());
		return"OrderMethodRegister";
	}
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
public String saveOrder(
		@ModelAttribute OrderMethodType orderMethodType, Model model
		) {
		Integer id=service.saveOrderMethod(orderMethodType);
		String message="OrderMethodType  ' "+id+" '  saved";
		model.addAttribute("message",message);
		model.addAttribute("orderMethodType",new OrderMethodType());
		return"OrderMethodRegister";
		}
	@RequestMapping("/all")
	public String getAllOrderMethodType(Model model) {
		List<OrderMethodType> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodDataType";
	}
	@RequestMapping("/delete")
	public String deleteOrderMethod(
			@RequestParam("ordid")Integer id,Model model
			) {
		service.deleteOrderMethod(id);
		String message="OrderMethod  '"+id+"' deleted";
		model.addAttribute("message",message);
		//fetch the new data
		List<OrderMethodType> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodDataType" ;
	}
	@RequestMapping("edit")
	public String getOneOrderMethod(
						@RequestParam("ordid")Integer id,Model model
						) {
		OrderMethodType om=service.getOneOrderMethod(id);
		model.addAttribute("orderMethodType",om);
		return "OrderMethodEdit";
	}
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateOrderMthod(
			@ModelAttribute  OrderMethodType orderMethodType ,Model model
			) {
		service.updateOrderMethod(orderMethodType);
		String message="OrderMethodType      '"+orderMethodType.getOrderId()+"'  Updated";
		List<OrderMethodType> list=service.getAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodDataType";
	}
	@RequestMapping("/view")
	public String getOrderMethod(
			@RequestParam("ordid")Integer id, Model model
			) {
		OrderMethodType om=service.getOneOrderMethod(id);
		model.addAttribute("ob",om);
		return "OrderMethodView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="id",required =false)Integer id
			) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		if(id==null) {
			//export all rows
		List<OrderMethodType> list=service.getAllOrderMethod();
		m.addObject("list",list);
		}
		else {
			//export one row by id
			OrderMethodType ot=service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(ot));
		}
		return m;
		
	}
	@RequestMapping("/pdf")
	public ModelAndView orderMethodPdf(
			@RequestParam(value="id",required =false)Integer id
			) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdf());
		if(id==null) {
			//show all data
		
		List<OrderMethodType>list=service.getAllOrderMethod();
		//send data to pdf
		m.addObject("list",list);
		}
		else {
			OrderMethodType ot=service.getOneOrderMethod(id);
			m.addObject("list", Arrays.asList(ot));
		}
		return m;
	}
	@RequestMapping("charts")
	public String showCharts() {
		List<Object[]> list=service.getOrderMethodModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "OrderMethodCharts";
		
	}
}
