package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.UomType;

public class UomTypeExclView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//file name
		response.addHeader("Content-Dispostion", "attachment;filename=UomType.Xlsx");
//creating a one new sheet by using workbook
		Sheet s=workbook.createSheet("UomType");
		//create rows in book
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<UomType>list=(List<UomType>)model.get("list");
		setBody(s,list);
	}
	private void setHeader(Sheet s) {
Row r=s.createRow(0);
r.createCell(0).setCellValue(" UMID");
r.createCell(1).setCellValue("UMTYPE");
r.createCell(2).setCellValue("UOMMODEL");
r.createCell(3).setCellValue("NOTE");
	}
	private void setBody(Sheet s, List<UomType> list) {
		int count=1;
		for(UomType um:list) {
			Row r=s.createRow(count++);
			
			
			
			r.createCell(0).setCellValue(um.getUomId());
			r.createCell(1).setCellValue(um.getUomType());
			r.createCell(2).setCellValue(um.getUomModel());
			r.createCell(3).setCellValue(um.getDescription());
		}
	}
}
