package gui.flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.FlightServicesDelegate;
import entities.Flight;
import entities.FlightMatching;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeeAllFlights extends JFrame {

	private JPanel contentPane;
	List<FlightMatching> flightsMatching;
	FlightMatching flightSelected=new FlightMatching();
	private Integer userId=1;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeAllFlights frame = new SeeAllFlights();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeeAllFlights() {
		
		flightsMatching = FlightServicesDelegate.doFindAllFlightMatching();
		
		setTitle("See all the flights");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "All the flights", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		
		JButton btnSeeStatistics = new JButton("See statistics");
		btnSeeStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
		
			/*	while (j.hasNext()) {
					departure = ((FlightMatching) j.next());
					//comboBoxFrom.addItem(departure.getDeparture());
			for(int i=0;i<allFlights.size();i++)
			{
				if(allFlights.contains(o).equals(departure.getDeparture())){
					count[i]++;
					System.out.println("Count"+i+" = "+count[i]+"Pays"+i+" = "+);
				}
			}
	
				}
				*/
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(571, Short.MAX_VALUE)
					.addComponent(btnSeeStatistics)
					.addGap(44))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSeeStatistics)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<FlightMatching, List<FlightMatching>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, flightsMatching, table);
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty = BeanProperty.create("idFlightMatching");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty).setColumnName("Flight Id");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_1 = BeanProperty.create("numFlight");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_1).setColumnName("Flight number");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_2 = BeanProperty.create("departure");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_2).setColumnName("Departure location");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_3 = BeanProperty.create("dateFlightMatchingArr");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_3).setColumnName("Departure date");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_4 = BeanProperty.create("timeFlightMatchingDep");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_4).setColumnName("Departure time");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_5 = BeanProperty.create("arrival");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_5).setColumnName("Arrival location");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_6 = BeanProperty.create("dateFlightMatchingArr");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_6).setColumnName("Arrival date");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_7 = BeanProperty.create("timeFlightMatchingArr");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_7).setColumnName("Arrival time");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_8 = BeanProperty.create("airline");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_8).setColumnName("Airline");
		//
		BeanProperty<FlightMatching, Double> flightMatchingBeanProperty_9 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_9).setColumnName("Price");
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty_10 = BeanProperty.create("numberOfSits");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_10).setColumnName("Number of sits");
		//
		jTableBinding.bind();
	}
}
