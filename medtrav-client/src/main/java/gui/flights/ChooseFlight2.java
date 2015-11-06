package gui.flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegates.FlightServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Flight;
import entities.FlightMatching;
import entities.Patient;
import entities.Testimony;
import gui.testimonies.TestimonyInterface;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseFlight2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<FlightMatching> flights;
	FlightMatching flightSelected = new FlightMatching();
	static String from;
	static String to;
	static String dateArrivalBDD;
	static String dateDepBDD;
	private JPanel panel_1;
	private JLabel lblId;
	private JTextField idFlight;
	private JTextField flightNumber;
	private JTextField departureLocationFlight;
	private JTextField arrivalLocationFlight;
	private JTextField departureDateFlight;
	private JTextField arrivalDateFlight;
	private JTextField airlineFlight;
	private JTextField numberSitsFlight;
	private JButton btnAddThisFlight;
	private JLabel lblPrice;
	private JTextField priceFlight;
	private JLabel lblArrivalTime;
	private JTextField arrivalTimeFlight;
	private JLabel lblDepartureTime;
	private JTextField departureTimeFlight;
	private JTextField hiddenNbSits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFlight2 frame = new ChooseFlight2(from, to,
							dateDepBDD, dateArrivalBDD);
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

	public ChooseFlight2(String from, String to, String dateDepBDD,
			String dateArrivalBDD) {
		this.from = from;
		this.to = to;
		this.dateDepBDD = dateDepBDD;
		this.dateArrivalBDD = dateArrivalBDD;
		
		System.out.println("from de choose = " + from);
		System.out.println("to de choose = " + to);
		System.out.println("date dep choose = " + dateDepBDD);
		System.out.println("date arrival choose = " + dateArrivalBDD);

		flights = FlightServicesDelegate.doFindMatchingFlight(this.from,
				this.to, this.dateDepBDD, this.dateArrivalBDD);
		setTitle("Choose a flight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);

		lblId = new JLabel("Id");

		idFlight = new JTextField();
		idFlight.setEnabled(false);
		idFlight.setColumns(10);

		JLabel lblFlightNumber = new JLabel("Flight number");

		flightNumber = new JTextField();
		flightNumber.setEnabled(false);
		flightNumber.setColumns(10);

		JLabel lblDepartureLocation = new JLabel("Departure location");

		departureLocationFlight = new JTextField();
		departureLocationFlight.setEnabled(false);
		departureLocationFlight.setColumns(10);

		JLabel lblArrivalLocation = new JLabel("Arrival location");

		arrivalLocationFlight = new JTextField();
		arrivalLocationFlight.setEnabled(false);
		arrivalLocationFlight.setColumns(10);

		JLabel lblDepartureDate = new JLabel("Departure date");

		departureDateFlight = new JTextField();
		departureDateFlight.setEnabled(false);
		departureDateFlight.setColumns(10);

		JLabel lblArrivalDate = new JLabel("Arrival date");

		arrivalDateFlight = new JTextField();
		arrivalDateFlight.setEnabled(false);
		arrivalDateFlight.setColumns(10);

		JLabel lblAirline = new JLabel("Airline");

		airlineFlight = new JTextField();
		airlineFlight.setEnabled(false);
		airlineFlight.setColumns(10);

		JLabel lblNumberOfSits = new JLabel("Number of sits");

		numberSitsFlight = new JTextField();
		numberSitsFlight.setColumns(10);

		btnAddThisFlight = new JButton("Add this flight");
		
		btnAddThisFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Flight flight = new Flight();
				Patient patient = FlightServicesDelegate.doFindPatientById(2);
				System.out.println("nomPatient= " + patient.getFirstName());

				flight.setPatient(patient);
				flight.setAirline(airlineFlight.getText());
				flight.setArrivalDate(arrivalDateFlight.getText());
				flight.setArrivalLocation(arrivalLocationFlight.getText());
				flight.setTimeFlightMatchingArr(arrivalTimeFlight.getText());
				flight.setDepartureDate(departureDateFlight.getText());
				flight.setDepartureLocation(departureLocationFlight.getText());
				flight.setTimeFlightMatchingDep(departureTimeFlight.getText());
				flight.setPrice(Double.parseDouble(priceFlight.getText()));
				flight.setNbSits(Integer.parseInt(numberSitsFlight.getText()));

				Integer nbSitsAvailable=(Integer)table.getValueAt(table.getSelectedRow(), 10);
				Integer nbSitsNeeded = Integer.parseInt(numberSitsFlight.getText());
				
			    System.out.println("Nb sits avaiable = "+nbSitsAvailable);
				System.out.println("Nb sits needed = "+nbSitsNeeded);

				if (nbSitsAvailable-nbSitsNeeded>=0) {
				FlightServicesDelegate.doAddFlight(flight);
				
				Integer numFlight=(Integer)table.getValueAt(table.getSelectedRow(), 0);
			    System.out.println("Num vol = "+numFlight);

			  //  FlightMatching fm1=FlightServicesDelegate.doFindFlightMatchingByNumFlight(numFlight);
			    FlightMatching fm1=FlightServicesDelegate.doFindFlightMatchingById(numFlight);

			    
			System.out.println(" données flight = "+fm1.getAirline()+fm1.getNumberOfSits());
			
			Integer nbSitsInitial=fm1.getNumberOfSits();
			Integer nbSitsMaj=nbSitsInitial-nbSitsNeeded;
			
			fm1.setNumberOfSits(nbSitsMaj);
			Boolean a = FlightServicesDelegate.doUpdateNbSits(nbSitsMaj,numFlight);
			System.out.println("bool val = "+a);
	
			
			System.out.println("NbSitsMaj = "+nbSitsMaj);
				
					JOptionPane.showMessageDialog(null, "Flight successfully added");
				} else {
					Integer numFlight=(Integer)table.getValueAt(table.getSelectedRow(), 0);
					 FlightMatching fm1=FlightServicesDelegate.doFindFlightMatchingById(numFlight);
					System.out.println("Failed to add a flight!");
					JOptionPane.showMessageDialog(null, "Sorry, there is not enough sits. We only have "+fm1.getNumberOfSits()+" available sits");

				}
				ManageFlights testInt = new ManageFlights();
				testInt.setVisible(true);

			}
		});

		lblPrice = new JLabel("Price");

		priceFlight = new JTextField();
		priceFlight.setEnabled(false);
		priceFlight.setColumns(10);
		
		lblArrivalTime = new JLabel("Arrival time");
		
		arrivalTimeFlight = new JTextField();
		arrivalTimeFlight.setEnabled(false);
		arrivalTimeFlight.setColumns(10);
		
		lblDepartureTime = new JLabel("Departure time");
		
		departureTimeFlight = new JTextField();
		departureTimeFlight.setEnabled(false);
		departureTimeFlight.setColumns(10);
		
		hiddenNbSits = new JTextField();
		hiddenNbSits.setVisible(false);
		hiddenNbSits.setEnabled(false);
		hiddenNbSits.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFlightNumber)
						.addComponent(lblId)
						.addComponent(lblDepartureLocation)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addGap(40)
								.addComponent(hiddenNbSits, 0, 0, Short.MAX_VALUE))
							.addComponent(lblArrivalLocation, Alignment.LEADING)))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(flightNumber, 157, 157, 157)
						.addComponent(idFlight, 157, 157, 157)
						.addComponent(departureLocationFlight, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addComponent(arrivalLocationFlight, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(lblAirline)
							.addComponent(lblArrivalDate))
						.addComponent(lblNumberOfSits)
						.addComponent(lblDepartureDate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(numberSitsFlight)
						.addComponent(airlineFlight)
						.addComponent(departureDateFlight)
						.addComponent(arrivalDateFlight, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(4)
								.addComponent(lblPrice)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(priceFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblDepartureTime)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(departureTimeFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblArrivalTime)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(arrivalTimeFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(btnAddThisFlight))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblDepartureTime)
						.addComponent(departureTimeFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(departureDateFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepartureDate))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFlightNumber)
								.addComponent(flightNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(arrivalDateFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblArrivalDate))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrice)
								.addComponent(airlineFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDepartureLocation)
								.addComponent(departureLocationFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAirline)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArrivalTime)
								.addComponent(arrivalTimeFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(priceFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(numberSitsFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblArrivalLocation)
								.addComponent(arrivalLocationFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumberOfSits))
							.addGap(26)
							.addComponent(hiddenNbSits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(btnAddThisFlight))
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								636, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								126, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<FlightMatching, List<FlightMatching>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, flights, table);
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty = BeanProperty.create("idFlightMatching");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty).setColumnName("IdFlight");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_1 = BeanProperty.create("numFlight");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_1).setColumnName("Num Flight");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_2 = BeanProperty.create("departure");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_2).setColumnName("Departure location");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_3 = BeanProperty.create("dateFlightMatchingDep");
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
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_7).setColumnName("Arrival Time");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_15 = BeanProperty.create("airline");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_15).setColumnName("Airline");
		//
		BeanProperty<FlightMatching, Double> flightMatchingBeanProperty_16 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_16).setColumnName("Price");
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty_18 = BeanProperty.create("numberOfSits");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_18).setColumnName("Number of sits");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty.create("selectedElement.idFlightMatching");
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty_8 = BeanProperty.create("idFlightMatching");
		AutoBinding<JTable, Integer, FlightMatching, Integer> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty, flightSelected, flightMatchingBeanProperty_8);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty.create("selectedElement.numFlight");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_9 = BeanProperty.create("numFlight");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_1, flightSelected, flightMatchingBeanProperty_9);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty.create("selectedElement.departure");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_10 = BeanProperty.create("departure");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_2, flightSelected, flightMatchingBeanProperty_10);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_3 = BeanProperty.create("selectedElement.arrival");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_11 = BeanProperty.create("arrival");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_3, flightSelected, flightMatchingBeanProperty_11);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty.create("selectedElement.dateFlightMatchingDep");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_12 = BeanProperty.create("dateFlightMatchingDep");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_4, flightSelected, flightMatchingBeanProperty_12);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_5 = BeanProperty.create("selectedElement.dateFlightMatchingArr");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_13 = BeanProperty.create("dateFlightMatchingArr");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_5, flightSelected, flightMatchingBeanProperty_13);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty.create("selectedElement.airline");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_14 = BeanProperty.create("airline");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_6, flightSelected, flightMatchingBeanProperty_14);
		autoBinding_6.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<FlightMatching, Integer, JTextField, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_8, idFlight, jTextFieldBeanProperty);
		autoBinding_8.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_9 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_9, flightNumber, jTextFieldBeanProperty_1);
		autoBinding_9.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_10 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_11, arrivalLocationFlight, jTextFieldBeanProperty_2);
		autoBinding_10.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_11 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_10, departureLocationFlight, jTextFieldBeanProperty_3);
		autoBinding_11.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_12 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_14, airlineFlight, jTextFieldBeanProperty_4);
		autoBinding_12.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_13 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_13, arrivalDateFlight, jTextFieldBeanProperty_5);
		autoBinding_13.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_14 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_12, departureDateFlight, jTextFieldBeanProperty_6);
		autoBinding_14.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_8 = BeanProperty.create("selectedElement.price");
		BeanProperty<FlightMatching, Double> flightMatchingBeanProperty_17 = BeanProperty.create("price");
		AutoBinding<JTable, Double, FlightMatching, Double> autoBinding_16 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_8, flightSelected, flightMatchingBeanProperty_17);
		autoBinding_16.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_8 = BeanProperty.create("text");
		AutoBinding<FlightMatching, Double, JTextField, String> autoBinding_17 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_17, priceFlight, jTextFieldBeanProperty_8);
		autoBinding_17.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_7 = BeanProperty.create("selectedElement.timeFlightMatchingDep");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_19 = BeanProperty.create("timeFlightMatchingDep");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_7, flightSelected, flightMatchingBeanProperty_19);
		autoBinding_7.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_9 = BeanProperty.create("selectedElement.timeFlightMatchingArr");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_20 = BeanProperty.create("timeFlightMatchingArr");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_15 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, table, jTableBeanProperty_9, flightSelected, flightMatchingBeanProperty_20);
		autoBinding_15.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_18 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_19, departureTimeFlight, jTextFieldBeanProperty_7);
		autoBinding_18.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_9 = BeanProperty.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_19 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_20, arrivalTimeFlight, jTextFieldBeanProperty_9);
		autoBinding_19.bind();
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty_21 = BeanProperty.create("numberOfSits");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_10 = BeanProperty.create("text");
		AutoBinding<FlightMatching, Integer, JTextField, String> autoBinding_20 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected, flightMatchingBeanProperty_21, hiddenNbSits, jTextFieldBeanProperty_10);
		autoBinding_20.bind();
	}
}
