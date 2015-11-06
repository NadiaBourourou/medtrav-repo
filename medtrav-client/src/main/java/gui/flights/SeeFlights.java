package gui.flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.FlightServicesDelegate;
import entities.Flight;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class SeeFlights extends JFrame {

	private JPanel contentPane;
	List<Flight> flights;
	Flight flightSelected = new Flight();
	private JTable table;
	private JLabel lblListFlights;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeFlights frame = new SeeFlights();
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
	public SeeFlights() {
		
		flights=FlightServicesDelegate.doFindAllFlight();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		lblListFlights = new JLabel("List flights");
		lblListFlights.setForeground(SystemColor.textHighlight);
		lblListFlights.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListFlights))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblListFlights)
					.addGap(73)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Flight, List<Flight>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, flights, table);
		//
		BeanProperty<Flight, Integer> flightBeanProperty = BeanProperty.create("flightId");
		jTableBinding.addColumnBinding(flightBeanProperty).setColumnName("IdFlight");
		//
		BeanProperty<Flight, Date> flightBeanProperty_1 = BeanProperty.create("departureDate");
		jTableBinding.addColumnBinding(flightBeanProperty_1).setColumnName("Departure Date");
		//
		BeanProperty<Flight, String> flightBeanProperty_2 = BeanProperty.create("arrivalLocation");
		jTableBinding.addColumnBinding(flightBeanProperty_2).setColumnName("Arrival Date");
		//
		BeanProperty<Flight, String> flightBeanProperty_3 = BeanProperty.create("departureLocation");
		jTableBinding.addColumnBinding(flightBeanProperty_3).setColumnName("Departure Location");
		//
		BeanProperty<Flight, String> flightBeanProperty_4 = BeanProperty.create("arrivalLocation");
		jTableBinding.addColumnBinding(flightBeanProperty_4).setColumnName("Arrival Location");
		//
		BeanProperty<Flight, Double> flightBeanProperty_5 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(flightBeanProperty_5).setColumnName("Price");
		//
		BeanProperty<Flight, String> flightBeanProperty_6 = BeanProperty.create("airline");
		jTableBinding.addColumnBinding(flightBeanProperty_6).setColumnName("Airline");
		//
		jTableBinding.bind();
	}
}
