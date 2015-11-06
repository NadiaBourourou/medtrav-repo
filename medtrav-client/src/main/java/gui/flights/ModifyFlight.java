package gui.flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.FlightServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Flight;
import entities.FlightMatching;
import entities.Patient;
import gui.testimonies.TestimonyInterface;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.border.TitledBorder;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyFlight extends JFrame {

	private JPanel contentPane;
	static String from;
	static String to;
	static Integer flightIdModif;
	List<FlightMatching> flightsMatching;
	FlightMatching flightSelected = new FlightMatching();
	private Integer userId = 1;
	private JTable table;
	private JTextField idFlight;
	private JTextField flightNumber;
	private JTextField departureLocation;
	private JTextField arrivalLocation;
	private JTextField departureDate;
	private JTextField arrivalDate;
	private JTextField airline;
	private JTextField numberOfSits;
	private JTextField departureTime;
	private JTextField arrivalTime;
	private JTextField Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFlight frame = new ModifyFlight(from, to,
							flightIdModif);
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
	public ModifyFlight(String from, String to, Integer flightIdModif) {
		this.from = from;
		this.to = to;
		this.flightIdModif = flightIdModif;

		System.out.println("from de choose = " + from);
		System.out.println("to de choose = " + to);
		System.out.println("flightIdModif de choose = " + flightIdModif);

		flightsMatching = FlightServicesDelegate
				.doFindMatchingFlightWithThatFromAndTo(this.from, this.to);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.textHighlight);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Flight modifications",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				SystemColor.textHighlight));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				panel,
																				GroupLayout.DEFAULT_SIZE,
																				716,
																				Short.MAX_VALUE))
														.addComponent(
																panel_1,
																GroupLayout.PREFERRED_SIZE,
																706,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(37)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 26,
								Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 195,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));

		JLabel label = new JLabel("Id");

		idFlight = new JTextField();
		idFlight.setEnabled(false);
		idFlight.setColumns(10);

		JLabel label_1 = new JLabel("Flight number");

		flightNumber = new JTextField();
		flightNumber.setEnabled(false);
		flightNumber.setColumns(10);

		departureLocation = new JTextField();
		departureLocation.setEnabled(false);
		departureLocation.setColumns(10);

		JLabel label_2 = new JLabel("Departure location");

		JLabel label_3 = new JLabel("Arrival location");

		arrivalLocation = new JTextField();
		arrivalLocation.setEnabled(false);
		arrivalLocation.setColumns(10);

		JLabel label_4 = new JLabel("Departure date");

		departureDate = new JTextField();
		departureDate.setEnabled(false);
		departureDate.setColumns(10);

		JLabel label_5 = new JLabel("Arrival date");

		arrivalDate = new JTextField();
		arrivalDate.setEnabled(false);
		arrivalDate.setColumns(10);

		JLabel label_6 = new JLabel("Airline");

		airline = new JTextField();
		airline.setEnabled(false);
		airline.setColumns(10);

		JLabel label_7 = new JLabel("Number of sits");

		numberOfSits = new JTextField();
		numberOfSits.setColumns(10);

		JLabel label_8 = new JLabel("Departure time");

		departureTime = new JTextField();
		departureTime.setEnabled(false);
		departureTime.setColumns(10);

		arrivalTime = new JTextField();
		arrivalTime.setEnabled(false);
		arrivalTime.setColumns(10);

		JLabel label_9 = new JLabel("Arrival time");

		Price = new JTextField();
		Price.setEnabled(false);
		Price.setColumns(10);

		JLabel label_10 = new JLabel("Price");

		JButton btnConfirmUpdate = new JButton("Confirm update");
		btnConfirmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flight flight1 = FlightServicesDelegate
						.doFindFlightById(flightIdModif);

				//

				Patient patient = FlightServicesDelegate
						.doFindPatientById(userId);
				System.out.println("nomPatient= " + patient.getFirstName());
				try {
					flight1.setPatient(patient);
					flight1.setAirline(airline.getText());
					flight1.setArrivalDate(arrivalDate.getText());
					flight1.setArrivalLocation(arrivalLocation.getText());
					flight1.setTimeFlightMatchingArr(arrivalTime.getText());
					flight1.setDepartureDate(departureDate.getText());
					flight1.setDepartureLocation(departureLocation.getText());
					flight1.setTimeFlightMatchingDep(departureTime.getText());
					flight1.setPrice(Double.parseDouble(Price.getText()));
					flight1.setNbSits(Integer.parseInt(numberOfSits.getText()));
					flight1.setNumFlight(flightNumber.getText());
			
					FlightServicesDelegate.doUpdateFlight(flight1);
					initDataBindings();
					
					JOptionPane.showMessageDialog(null, "Flight successfully modified");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error modifying flight");
				}

				ModifyCancelFlight interfaceOfAllMyFlights = new ModifyCancelFlight();
				interfaceOfAllMyFlights.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				label,
																				GroupLayout.PREFERRED_SIZE,
																				10,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(93)
																		.addComponent(
																				idFlight,
																				GroupLayout.PREFERRED_SIZE,
																				157,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				label_4,
																				GroupLayout.PREFERRED_SIZE,
																				87,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				departureDate,
																				GroupLayout.PREFERRED_SIZE,
																				139,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				label_8,
																				GroupLayout.PREFERRED_SIZE,
																				84,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				departureTime,
																				GroupLayout.PREFERRED_SIZE,
																				86,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				label_1,
																				GroupLayout.PREFERRED_SIZE,
																				85,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				flightNumber,
																				GroupLayout.PREFERRED_SIZE,
																				157,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				label_5,
																				GroupLayout.PREFERRED_SIZE,
																				65,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				arrivalDate,
																				GroupLayout.PREFERRED_SIZE,
																				139,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(22)
																		.addComponent(
																				label_9,
																				GroupLayout.PREFERRED_SIZE,
																				66,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				arrivalTime,
																				GroupLayout.PREFERRED_SIZE,
																				86,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								label_3,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								label_2,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								93,
																								Short.MAX_VALUE))
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												departureLocation,
																												GroupLayout.PREFERRED_SIZE,
																												157,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												label_6,
																												GroupLayout.PREFERRED_SIZE,
																												29,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(54)
																										.addComponent(
																												airline,
																												GroupLayout.PREFERRED_SIZE,
																												139,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								Alignment.TRAILING,
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(10)
																										.addComponent(
																												arrivalLocation,
																												GroupLayout.PREFERRED_SIZE,
																												157,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(14)
																										.addComponent(
																												label_7,
																												GroupLayout.PREFERRED_SIZE,
																												69,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												numberOfSits,
																												GroupLayout.PREFERRED_SIZE,
																												139,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(26)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addComponent(
																												label_10,
																												GroupLayout.PREFERRED_SIZE,
																												54,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												Price,
																												GroupLayout.PREFERRED_SIZE,
																												86,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								btnConfirmUpdate))))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap(
																				24,
																				Short.MAX_VALUE)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(3)
																										.addComponent(
																												label))
																						.addComponent(
																								idFlight,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panel_1
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												departureDate,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												label_4))
																						.addComponent(
																								departureTime,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(27)
																		.addComponent(
																				label_8)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)))
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												flightNumber,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												label_5))
																						.addComponent(
																								arrivalDate,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								arrivalTime,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(21)
																		.addComponent(
																				label_1))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(21)
																		.addComponent(
																				label_9)))
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												departureLocation,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												label_6))
																						.addComponent(
																								airline,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								Price,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(21)
																		.addComponent(
																				label_2))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(21)
																		.addComponent(
																				label_10)))
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(19)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												arrivalLocation,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												label_7))
																						.addComponent(
																								numberOfSits,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				btnConfirmUpdate))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(22)
																		.addComponent(
																				label_3)))
										.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								664, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								104, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(57, Short.MAX_VALUE)));

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<FlightMatching, List<FlightMatching>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ_WRITE,
						flightsMatching, table);
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty = BeanProperty
				.create("idFlightMatching");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty)
				.setColumnName("Id Flight");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_1 = BeanProperty
				.create("numFlight");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_1)
				.setColumnName("Flight number");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_2 = BeanProperty
				.create("departure");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_2)
				.setColumnName("Departure location");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_3 = BeanProperty
				.create("dateFlightMatchingDep");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_3)
				.setColumnName("Departure date");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_4 = BeanProperty
				.create("timeFlightMatchingDep");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_4)
				.setColumnName("Departure time");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_5 = BeanProperty
				.create("arrival");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_5)
				.setColumnName("Arrival location");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_6 = BeanProperty
				.create("dateFlightMatchingArr");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_6)
				.setColumnName("Arrival date");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_7 = BeanProperty
				.create("timeFlightMatchingArr");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_7)
				.setColumnName("Arrival time");
		//
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_8 = BeanProperty
				.create("airline");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_8)
				.setColumnName("Airline");
		//
		BeanProperty<FlightMatching, Double> flightMatchingBeanProperty_9 = BeanProperty
				.create("price");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_9)
				.setColumnName("Price");
		//
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty_10 = BeanProperty
				.create("numberOfSits");
		jTableBinding.addColumnBinding(flightMatchingBeanProperty_10)
				.setColumnName("Number of sits");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty
				.create("selectedElement.idFlightMatching");
		BeanProperty<FlightMatching, Integer> flightMatchingBeanProperty_11 = BeanProperty
				.create("idFlightMatching");
		AutoBinding<JTable, Integer, FlightMatching, Integer> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty, flightSelected,
						flightMatchingBeanProperty_11);
		autoBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
				.create("selectedElement.numFlight");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_12 = BeanProperty
				.create("numFlight");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_1, flightSelected,
						flightMatchingBeanProperty_12);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty
				.create("selectedElement.departure");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_13 = BeanProperty
				.create("departure");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_2, flightSelected,
						flightMatchingBeanProperty_13);
		autoBinding_2.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_3 = BeanProperty
				.create("selectedElement.dateFlightMatchingDep");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_14 = BeanProperty
				.create("dateFlightMatchingDep");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_3, flightSelected,
						flightMatchingBeanProperty_14);
		autoBinding_3.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty
				.create("selectedElement.timeFlightMatchingDep");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_15 = BeanProperty
				.create("timeFlightMatchingDep");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_4, flightSelected,
						flightMatchingBeanProperty_15);
		autoBinding_4.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_5 = BeanProperty
				.create("selectedElement.arrival");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_16 = BeanProperty
				.create("arrival");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_5 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_5, flightSelected,
						flightMatchingBeanProperty_16);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty
				.create("selectedElement.dateFlightMatchingArr");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_17 = BeanProperty
				.create("dateFlightMatchingArr");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_6 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_6, flightSelected,
						flightMatchingBeanProperty_17);
		autoBinding_6.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_7 = BeanProperty
				.create("selectedElement.timeFlightMatchingArr");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_18 = BeanProperty
				.create("timeFlightMatchingArr");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_7 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_7, flightSelected,
						flightMatchingBeanProperty_18);
		autoBinding_7.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty_8 = BeanProperty
				.create("selectedElement.airline");
		BeanProperty<FlightMatching, String> flightMatchingBeanProperty_19 = BeanProperty
				.create("airline");
		AutoBinding<JTable, String, FlightMatching, String> autoBinding_8 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_8, flightSelected,
						flightMatchingBeanProperty_19);
		autoBinding_8.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_9 = BeanProperty
				.create("selectedElement.price");
		BeanProperty<FlightMatching, Double> flightMatchingBeanProperty_20 = BeanProperty
				.create("price");
		AutoBinding<JTable, Double, FlightMatching, Double> autoBinding_9 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, table,
						jTableBeanProperty_9, flightSelected,
						flightMatchingBeanProperty_20);
		autoBinding_9.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, Integer, JTextField, String> autoBinding_11 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_11, idFlight,
						jTextFieldBeanProperty);
		autoBinding_11.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_12 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_14, departureDate,
						jTextFieldBeanProperty_1);
		autoBinding_12.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_13 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_15, departureTime,
						jTextFieldBeanProperty_2);
		autoBinding_13.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_14 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_12, flightNumber,
						jTextFieldBeanProperty_3);
		autoBinding_14.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_15 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_17, arrivalDate,
						jTextFieldBeanProperty_4);
		autoBinding_15.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_16 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_18, arrivalTime,
						jTextFieldBeanProperty_5);
		autoBinding_16.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_17 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_13, departureLocation,
						jTextFieldBeanProperty_6);
		autoBinding_17.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_18 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_19, airline,
						jTextFieldBeanProperty_7);
		autoBinding_18.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_8 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, String, JTextField, String> autoBinding_19 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_16, arrivalLocation,
						jTextFieldBeanProperty_8);
		autoBinding_19.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty_10 = BeanProperty
				.create("text");
		AutoBinding<FlightMatching, Double, JTextField, String> autoBinding_21 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
						flightMatchingBeanProperty_20, Price,
						jTextFieldBeanProperty_10);
		autoBinding_21.bind();
	}
}
