package gui.flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.FlightServicesDelegate;
import delegates.UserServicesDelegate;
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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class SeeAllFlights extends JFrame {

	private JPanel contentPane;
	List<FlightMatching> flightsMatching;
	FlightMatching flightSelected=new FlightMatching();
	private Integer userId=1;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField searchTextField;
	
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
		setBounds(100, 100, 790, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "All the flights", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));

		
		JLabel lblSearchBy = new JLabel("Search by");
		
		JRadioButton rdbtnDepatureLocation = new JRadioButton("Departure location");
		buttonGroup.add(rdbtnDepatureLocation);
		
		JRadioButton rdbtnArrivalLocation = new JRadioButton("Arrival location");
		buttonGroup.add(rdbtnArrivalLocation);
		
		JRadioButton rdbtnAirline = new JRadioButton("Airline");
		buttonGroup.add(rdbtnAirline);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(SeeAllFlights.class.getResource("/images/Search.png")));
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDepatureLocation.isSelected()){
					System.out.println("traitement pr depart");
					flightsMatching=FlightServicesDelegate.doFindFlightByDepartureLocation(searchTextField.getText());
					initDataBindings();
				}
				
				if(rdbtnArrivalLocation.isSelected()){
					System.out.println("traitement pr arrival");
					flightsMatching=FlightServicesDelegate.doFindFlightByArrivalLocation(searchTextField.getText());
					initDataBindings();
				}
				
				
				if(rdbtnAirline.isSelected()){
					System.out.println("traitement pr airline");
					flightsMatching=FlightServicesDelegate.doFindFlightByAirline(searchTextField.getText());
					initDataBindings();
				}

			}
		});
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AddFlight2.class.getResource("/images/smallLogo.png")));
		lblLogo.setBounds(10, 0, 69, 73);
		
		JButton buttonHome = new JButton("");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageFlights home= new ManageFlights();
				home.setVisible(true);
				SeeAllFlights.this.setVisible(false);
			}
		});
		buttonHome.setIcon(new ImageIcon(SeeAllFlights
				.class.getResource("/images/blue-home-icon.png")));
		buttonHome.setBounds(10, 331, 160, 43);
		
		JLabel lblSeeAllThe = new JLabel("See all the flights");
		lblSeeAllThe.setForeground(new Color(135, 206, 250));
		lblSeeAllThe.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSearchBy)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnDepatureLocation)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnArrivalLocation)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnAirline)
									.addGap(18)
									.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE))
							.addGap(33))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLogo)
							.addGap(172)
							.addComponent(lblSeeAllThe, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
							.addComponent(buttonHome, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogo)
						.addComponent(buttonHome)
						.addComponent(lblSeeAllThe, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchBy)
						.addComponent(rdbtnDepatureLocation)
						.addComponent(rdbtnArrivalLocation)
						.addComponent(rdbtnAirline)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(135))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
