package gui.flights;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import delegates.FlightServicesDelegate;
import entities.User;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
 
public class Statistiques extends ApplicationFrame 
{
   public Statistiques( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
	
   }
   
   
   public Statistiques( String title, User user ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
	
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
      
      int width = 640; /* Width of the image */
      int height = 480; /* Height of the image */ 
      File pieChart = new File( "C:\\medTrav\\PieChart.png" ); 
try {
ChartUtilities.saveChartAsPNG(pieChart, chart, width, height);
JOptionPane.showMessageDialog(null,"Image generated successfully. You can find it under your C:  folder. ");
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
      

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args )
   {
      Statistiques demo = new Statistiques( "Airline partners" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
      
      
      
      
   }
}
