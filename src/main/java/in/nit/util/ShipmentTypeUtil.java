package in.nit.util;

import java.io.File;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
	@SuppressWarnings("deprecation")
	public void generatePie(String path,List<Object[]> data) {
		//create data 
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] arr:data) {
			//key-shipMode, value-count
			dataset.setValue(arr[0].toString(), new Double/*or .valueof*/(arr[1].toString()));
		}
		//2.create JFreeChart using ChartFactory
		JFreeChart chart=ChartFactory.createPieChart("ShipmentTypeModes", dataset,true,true,false);
		//save as image using chartUtiles
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentA.jpg"), chart,400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
