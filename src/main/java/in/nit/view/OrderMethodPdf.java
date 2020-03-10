package in.nit.view;

import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.OrderMethodType;


public class OrderMethodPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=order.pdf");
		//create the element
		Paragraph p=new Paragraph();
		//add element to document
		document.add(p);
		//read data from model
		List<OrderMethodType> list=(List<OrderMethodType>) model.get("list");
		//createing table with no.of columns
		PdfPTable t=new PdfPTable(6);
		t.addCell("ORDERID");
		t.addCell("ORDERMODE");
		t.addCell("ORDERCODE");
		t.addCell("ORDERTYPE");
		t.addCell("ORDERACCEPT");
		t.addCell("DESCRIPTION");
		//adding data to the table
		for(OrderMethodType om:list) {
		t.addCell(om.getOrderId().toString());
		t.addCell(om.getOrderMode());
		t.addCell(om.getOrderCode());
		t.addCell(om.getOrderType());
		t.addCell( om.getOrderAccept()!=null?
				om.getOrderAccept().toString():"[]");
		t.addCell(om.getDescription());
	}

//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
}
}