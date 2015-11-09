package gui.flights;

import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import delegates.FlightServicesDelegate;
 
public class StatEssai extends ApplicationFrame 
{
   public StatEssai( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   private static PieDataset createDataset( ) 
   {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	     
		List<String> ourAirlines=FlightServicesDelegate.doFindAllAirlines();
		
		for(int i=0;i<ourAirlines.size();i++)
		{
		
		//System.out.println(ourAirlines.get(i));
		long nbOcc= FlightServicesDelegate.doMostWorkingAirlines(ourAirlines.get(i));
		//System.out.println(ourAirlines.get(i)+" "+nbOcc);
		
		   dataset.setValue( ourAirlines.get(i) , nbOcc );
		   
		}

      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Airline partners",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args )
   {
      StatEssai demo = new StatEssai( "Airline partners" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
      
      
   }
}