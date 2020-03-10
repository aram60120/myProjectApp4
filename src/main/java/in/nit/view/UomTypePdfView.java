package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.UomType;

public class UomTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=UomType.pdf");
		//create element
		Paragraph p=new Paragraph();
		//add element to document
		document.add(p);
		//read data from model
		List<UomType> list=(List<UomType>) model.get("list");
		//create table with no of columns
		PdfPTable t=new PdfPTable(4);
		t.addCell("UMID");
		t.addCell("UMTYPE");
		t.addCell("UOMMODEL");
		t.addCell("NOTE");
		//adding data to table
		for(UomType um:list) {
			t.addCell(um.getUomId().toString());
			t.addCell(um.getUomType());
			t.addCell(um.getUomModel());
			t.addCell(um.getDescription());
		}
		document.add(t);		
		//print Date and time
		document.add(new Paragraph(new Date().toString()));
	}

}
