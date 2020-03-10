
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

import in.nit.model.UomType;
import in.nit.service.IUomTypeService;
import in.nit.view.UomTypeExclView;
import in.nit.view.UomTypePdfView;
import in.nit.util.UomTypeUtil;
@Controller
@RequestMapping("/uom")
public class UomTypeController {
	@Autowired
	private IUomTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	 private UomTypeUtil util;
	 
	 
	@RequestMapping("/register")
	public String showPage(Model model) {
		model.addAttribute("uomType",new UomType());
		return "UomTypeRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUom(
			@ModelAttribute UomType  uomType, Model model
			) {
		Integer id=service.saveUom( uomType);
		String message="UomType"+id+"saved";
		model.addAttribute("message",message);
		model.addAttribute("uomType",new UomType());
		return"UomTypeRegister";
	}

	@RequestMapping("/all") 
	public String getAllUomType(Model model ) {
		List<UomType> list=service.getAllUomType(); 
		model.addAttribute("list", list);
		return "UomTypeData";
	}
	@RequestMapping("/delete")
	public String deleteUomType(
			@RequestParam ("umid")Integer id,Model model
			) {
		service.deleteUomType(id);
		String message="UomType"+id+"deleted";		
		model.addAttribute("message",message);
		//fetch new data 
		List<UomType> list=service.getAllUomType();
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		return "UomTypeData";
	}
	@RequestMapping("/edit")
	public String getOneUomType(
			@RequestParam ("umid")Integer id, Model model
			) {
				UomType um=service.getOneUomType(id);
				model.addAttribute("uomType", um);
		return "UomTypeEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUomType(
			@ModelAttribute UomType uomType,Model model
			) {
		service.updateUomType(uomType);
		String message="UomType   '"+uomType.getUomId()+"' updated";
		model.addAttribute("message",message);
		List<UomType> list=service.getAllUomType();
		model.addAttribute("list",list);
		return "UomTypeData";
	}
	@RequestMapping("/view")
	public String showOneUomType(
			@RequestParam ("umid")Integer  id, Model model
			) {
		UomType um=service.getOneUomType(id);
		model.addAttribute("ob",um);
		return "UomTypeView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="id",required = false)Integer id
			) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomTypeExclView());
		if(id==null) {
		//fetching data from db
			//export all rows
		List<UomType> list=service.getAllUomType();
		m.addObject("list",list);
		}
		else {
		UomType um=service.getOneUomType(id);
		m.addObject("list",Arrays.asList(um));
		}
		
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="id",required = false)Integer id
			) {
	ModelAndView m=new ModelAndView();
	m.setView(new UomTypePdfView());
	if(id==null) {
		//show all data
		List<UomType> list=service.getAllUomType();
	//send data to pdf file
	m.addObject("list",list);
	}
	else {
		//one row
		UomType um=service.getOneUomType(id);
		m.addObject("list",Arrays.asList(um));
	}
		return m;
	}
	@RequestMapping("/charts")
 public String showCharts() {
	 List<Object[]> list=service.getuomTypeCount();
	 String path=context.getRealPath("/");
	 util.generatePieChart(path, list);
	 util.generateBarChart(path,list);
 return"UomTypeCharts";
 }
}



