package in.nit.util;

import java.io.File;

import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomTypeUtil {
	public void generatePieChart(String path,List<Object[]> data) {

		//1.Create data set
		DefaultPieDataset dataSet = new DefaultPieDataset();
		for(Object[] arr:data){
			dataSet.setValue(arr[0].toString(),  Double.valueOf(arr[1].toString()));
		}

		//2.converting data to JFreeChart
		JFreeChart chart=ChartFactory.createPieChart3D("UOM Pie Chart", dataSet, true, true, false);

		//3.save image as JPEG
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomTypepie.jpg"),chart,400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void generateBarChart(String path,List<Object[]> data) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] arr:data) {
			dataset.setValue( Double.valueOf(arr[1].toString()), arr[0].toString(), "");
		}

		JFreeChart chart=ChartFactory.createBarChart("UOM Bar Chart", "uomType", "Count", dataset);

		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomTypebar.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
