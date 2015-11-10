package gui.flights;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import delegates.FlightServicesDelegate;

public class GenerateImageStatistics {

	public static void main(String[] args) {
	
		 DefaultPieDataset dataset = new DefaultPieDataset( );
	     
			List<String> ourAirlines=FlightServicesDelegate.doFindAllAirlines();
			
			for(int i=0;i<ourAirlines.size();i++)
			{
			
			//System.out.println(ourAirlines.get(i));
			long nbOcc= FlightServicesDelegate.doMostWorkingAirlines(ourAirlines.get(i));
			//System.out.println(ourAirlines.get(i)+" "+nbOcc);
			
			   dataset.setValue( ourAirlines.get(i) , nbOcc );
			}  
			   JFreeChart chart = ChartFactory.createPieChart(      
				         "Airline partners",  // chart title 
				         dataset,        // data    
				         true,           // include legend   
				         true, 
				         false);

			
	         
			      int width = 640; /* Width of the image */
			      int height = 480; /* Height of the image */ 
			      File pieChart = new File( "C:\\Users\\usus\\git\\medtrav-repo\\medtrav-client\\src\\main\\java\\myCharts\\PieChart.png" ); 
		try {
			ChartUtilities.saveChartAsPNG(pieChart, chart, width, height);
			JOptionPane.showMessageDialog(null,"Image generated successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
