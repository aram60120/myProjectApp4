package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.OrderMethodType;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//file names
		response.addHeader("Content-Disposition", "attachment;filename=Order.xlsx");
		//create a one sheet
	Sheet s=workbook.createSheet("OrderMethodTypes");
	//create one row
	SetHeader(s);
	//read data from model class
	List<OrderMethodType> list=(List<OrderMethodType>) model.get("list");
	setBody(s,list);
		
	}

		private void SetHeader(Sheet s) {
         Row r=s.createRow(0);
         r.createCell(0).setCellValue("ORDERID");
         r.createCell(1).setCellValue("ORDERMODE");
         r.createCell(2).setCellValue("ORDERCODE");
         r.createCell(3).setCellValue("ORDERTYPE");
         r.createCell(4).setCellValue("ORDERACCEPT");
			r.createCell(5).setCellValue("DESCRIPTION");
			
	}
		private void setBody(Sheet s, List<OrderMethodType> list) {
                                      int count=1;
                                      for(OrderMethodType om:list) {
                                    	  Row r=s.createRow(count++);
                                    	  
                                    	  
                                    	  
                                    r.createCell(0).setCellValue(om.getOrderId());
                                    r.createCell(1).setCellValue(om.getOrderMode());
                                    r.createCell(2).setCellValue(om.getOrderCode());
                                    r.createCell(3).setCellValue(om.getOrderType());
                                    r.createCell(4).setCellValue(om.getOrderAccept()!=null?
                                    		om.getOrderAccept().toString():"[]");
                                    r.createCell(5).setCellValue(om.getDescription());
                                      }

		}


}
