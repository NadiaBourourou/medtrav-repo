package gui.flights; 

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegates.FlightServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Flight;
import entities.FlightMatching;
import entities.User;
import gui.Book;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.border.LineBorder;

public class ModifyCancelFlight extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<Flight> flights;
	Flight flightSelected = new Flight();
	// private Integer userId=1;
	private JTable table;
	private JTextField departureTime;
	private JTextField arrivalTime;
	private JTextField price;
	private JTextField departureDate;
	private JTextField arrivalDate;
	private JTextField airline;
	private JTextField nbSits;
	private JTextField IdFlight;
	private JTextField numberFlight;
	private JTextField DepartureLocation;
	private JTextField arrivalLocation;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	public void run() {
	try {
	ModifyCancelFlight frame = new ModifyCancelFlight();
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
	public ModifyCancelFlight(User user) {
	setTitle("Modify-Cancel my flight");
	setVisible(true);

	flights = FlightServicesDelegate.doFindAllFlighstByPatient(user.getUserId());

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 821, 532);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(UIManager
	.getBorder("TitledBorder.border"), "My flights",
	TitledBorder.LEFT, TitledBorder.TOP, null, Color.GRAY));

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new LineBorder(Color.GRAY));

	JLabel labelLogo = new JLabel("");
	labelLogo.setIcon(new ImageIcon(AddFlight2.class
	.getResource("/images/smallLogo.png")));
	labelLogo.setBounds(10, 0, 69, 73);

	JButton buttonHome = new JButton("");
	buttonHome.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	ManageFlights home = new ManageFlights(user);
	home.setVisible(true);
	ModifyCancelFlight.this.setVisible(false);
	}
	});
	buttonHome.setIcon(new ImageIcon(ModifyCancelFlight.class
	.getResource("/images/blue-home-icon.png")));
	buttonHome.setBounds(10, 331, 160, 43);

	departureTime = new JTextField();
	departureTime.setEnabled(false);
	departureTime.setColumns(10);

	arrivalTime = new JTextField();
	arrivalTime.setEnabled(false);
	arrivalTime.setColumns(10);

	price = new JTextField();
	price.setEnabled(false);
	price.setColumns(10);

	JLabel label = new JLabel("Price");

	JLabel label_1 = new JLabel("Arrival time");

	JLabel label_2 = new JLabel("Departure time");

	departureDate = new JTextField();
	departureDate.setEnabled(false);
	departureDate.setColumns(10);

	JLabel label_3 = new JLabel("Departure date");

	JLabel label_4 = new JLabel("Arrival date");

	arrivalDate = new JTextField();
	arrivalDate.setEnabled(false);
	arrivalDate.setColumns(10);

	JLabel label_5 = new JLabel("Airline");

	airline = new JTextField();
	airline.setEnabled(false);
	airline.setColumns(10);

	nbSits = new JTextField();
	nbSits.setEnabled(false);
	nbSits.setColumns(10);

	JLabel label_6 = new JLabel("Number of sits");

	JLabel label_7 = new JLabel("Id");

	IdFlight = new JTextField();
	IdFlight.setEnabled(false);
	IdFlight.setColumns(10);

	JLabel label_8 = new JLabel("Flight number");

	numberFlight = new JTextField();
	numberFlight.setEnabled(false);
	numberFlight.setColumns(10);

	DepartureLocation = new JTextField();
	DepartureLocation.setEnabled(false);
	DepartureLocation.setColumns(10);

	JLabel label_9 = new JLabel("Departure location");

	JLabel label_10 = new JLabel("Arrival location");

	arrivalLocation = new JTextField();
	arrivalLocation.setEnabled(false);
	arrivalLocation.setColumns(10);

	JButton btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	Integer flightIdModif = (Integer) table.getValueAt(
	table.getSelectedRow(), 0);
	System.out.println("from " + flightIdModif);

	String from = (String) table.getValueAt(table.getSelectedRow(),
	2);
	System.out.println("from " + from);

	String to = (String) table.getValueAt(table.getSelectedRow(), 5);
	System.out.println("to " + to);

	String numFlight = (String) table.getValueAt(
	table.getSelectedRow(), 1);
	System.out.println("numFlight " + numFlight);

	Integer nbSitsArendre = (Integer) table.getValueAt(
	table.getSelectedRow(), 8);
	System.out.println("nbSitsArendre " + nbSitsArendre);

	JOptionPane
	.showMessageDialog(
	null,
	"You are going to see all our available flights matching your depature and arrival locations");
	ModifyFlight modifyFlight = new ModifyFlight(from, to,
	flightIdModif, numFlight, nbSitsArendre, user);
	modifyFlight.setVisible(true);
	ModifyCancelFlight.this.setVisible(false);
	}
	});
	btnUpdate.setIcon(new ImageIcon(ModifyCancelFlight.class
	.getResource("/images/updateFlight.png")));

	JButton btnCancel = new JButton("Delete");
	btnCancel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	FlightServicesDelegate.doDeleteFlight(flightSelected);
	flights = FlightServicesDelegate.doFindAllFlight();
	initDataBindings();

	IdFlight.setText("");
	airline.setText("");
	arrivalDate.setText("");
	arrivalLocation.setText("");
	arrivalTime.setText("");
	departureDate.setText("");
	DepartureLocation.setText("");
	departureTime.setText("");
	price.setText("");
	nbSits.setText("");
	numberFlight.setText("");

	// /////////////////Remise du nbSits � l'ancien
	// vol///////////////

	System.out.println("hello");
	String numF = (String) table.getValueAt(table.getSelectedRow(),
	1);
	System.out.println("numF = " + numF);
	FlightMatching flightMatch = FlightServicesDelegate
	.doFindFlightMatchingByNumFlight(numF);
	System.out.println("comp aer = " + flightMatch.getAirline());

	Integer nbFlightArendre = (Integer) table.getValueAt(
	table.getSelectedRow(), 8);
	System.out.println("nbFlightArendre = " + nbFlightArendre);
	System.out.println("comp aer = " + flightMatch.getAirline());

	flightMatch.setNumberOfSits(flightMatch.getNumberOfSits()
	+ nbFlightArendre);
	FlightServicesDelegate.doUpdateNbSits(flightMatch);
	System.out.println("Nv numF = " + flightMatch.getNumberOfSits());

	// /////////////////Remise du nbSits � l'ancien
	// vol///////////////

	SeeMyFlights seeMyFlights = new SeeMyFlights(user);
	seeMyFlights.setVisible(true);
	ModifyCancelFlight.this.setVisible(false);

	}
	});
	btnCancel.setIcon(new ImageIcon(ModifyCancelFlight.class
	.getResource("/images/deleteFlight.png")));

	JScrollPane scrollPane = new JScrollPane();
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
	Alignment.LEADING).addGroup(
	gl_panel.createSequentialGroup()
	.addContainerGap()
	.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
	638, Short.MAX_VALUE).addContainerGap()));
	gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
	Alignment.LEADING).addGroup(
	gl_panel.createSequentialGroup()
	.addGap(13)
	.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
	101, Short.MAX_VALUE).addContainerGap()));

	table = new JTable();
	scrollPane.setViewportView(table);
	panel.setLayout(gl_panel);

	JLabel lblModifyCancel = new JLabel("Modify - Cancel my flight");
	lblModifyCancel.setForeground(new Color(135, 206, 250));
	lblModifyCancel.setFont(new Font("Tahoma", Font.BOLD, 23));
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
	gl_contentPane
	.createSequentialGroup()
	.addContainerGap()
	.addComponent(
	panel_1,
	GroupLayout.PREFERRED_SIZE,
	775,
	Short.MAX_VALUE))
	.addGroup(
	gl_contentPane
	.createSequentialGroup()
	.addGap(10)
	.addComponent(
	labelLogo)
	.addGap(86)
	.addComponent(
	lblModifyCancel,
	GroupLayout.PREFERRED_SIZE,
	339,
	GroupLayout.PREFERRED_SIZE)
	.addPreferredGap(
	ComponentPlacement.RELATED,
	218,
	Short.MAX_VALUE)
	.addComponent(
	buttonHome,
	GroupLayout.PREFERRED_SIZE,
	63,
	GroupLayout.PREFERRED_SIZE)))
	.addContainerGap())
	.addGroup(
	gl_contentPane
	.createSequentialGroup()
	.addContainerGap(77, Short.MAX_VALUE)
	.addComponent(panel,
	GroupLayout.PREFERRED_SIZE,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.PREFERRED_SIZE)
	.addGap(48)));
	gl_contentPane
	.setVerticalGroup(gl_contentPane
	.createParallelGroup(Alignment.LEADING)
	.addGroup(
	gl_contentPane
	.createSequentialGroup()
	.addContainerGap()
	.addGroup(
	gl_contentPane
	.createParallelGroup(
	Alignment.LEADING)
	.addGroup(
	gl_contentPane
	.createParallelGroup(
	Alignment.LEADING,
	false)
	.addComponent(
	buttonHome,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.DEFAULT_SIZE,
	Short.MAX_VALUE)
	.addComponent(
	labelLogo,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.DEFAULT_SIZE,
	Short.MAX_VALUE))
	.addComponent(
	lblModifyCancel,
	GroupLayout.PREFERRED_SIZE,
	96,
	GroupLayout.PREFERRED_SIZE))
	.addPreferredGap(
	ComponentPlacement.RELATED)
	.addComponent(panel,
	GroupLayout.PREFERRED_SIZE,
	125, GroupLayout.PREFERRED_SIZE)
	.addGap(18)
	.addComponent(panel_1,
	GroupLayout.PREFERRED_SIZE,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.PREFERRED_SIZE)
	.addGap(46)));
	
	JButton btnBook = new JButton("Book");
	btnBook.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Book next = new Book(user);
			next.setVisible(true);
			setVisible(false);
			
		}
	});
	
	GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	gl_panel_1.setHorizontalGroup(
		gl_panel_1.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_1.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addComponent(label_10)
					.addComponent(label_9)
					.addComponent(label_8)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(numberFlight, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addGap(27)
						.addComponent(label_4)
						.addGap(18)
						.addComponent(arrivalDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addGap(22)
						.addComponent(label_1)
						.addGap(22)
						.addComponent(arrivalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnBook)
								.addGap(22)
								.addComponent(btnUpdate))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(IdFlight, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addComponent(label_3)
								.addGap(4)
								.addComponent(departureDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(22)
								.addComponent(label_2)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(4)
								.addComponent(departureTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(18)
								.addComponent(btnCancel))))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(arrivalLocation, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addComponent(DepartureLocation, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_5)
								.addGap(44)
								.addComponent(airline, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(label)
								.addGap(49)
								.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_6)
								.addGap(4)
								.addComponent(nbSits, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(78, Short.MAX_VALUE))
	);
	gl_panel_1.setVerticalGroup(
		gl_panel_1.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_1.createSequentialGroup()
				.addGap(25)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(label_7)
						.addGap(21)
						.addComponent(label_8)
						.addGap(21)
						.addComponent(label_9)
						.addGap(22)
						.addComponent(label_10))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(IdFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_3))
							.addComponent(departureDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_2))
							.addComponent(departureTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(numberFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(arrivalDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_1))
							.addComponent(arrivalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(DepartureLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addComponent(airline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label))
							.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(arrivalLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_6))
							.addComponent(nbSits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnUpdate)
							.addComponent(btnCancel)
							.addComponent(btnBook))))
				.addContainerGap(25, Short.MAX_VALUE))
	);
	panel_1.setLayout(gl_panel_1);
	contentPane.setLayout(gl_contentPane);
	initDataBindings();
	}
	
	public ModifyCancelFlight() {
	setTitle("Modify-Cancel my flight");
	setVisible(true);

	flights = FlightServicesDelegate.doFindAllFlighstByPatient(user.getUserId());

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 821, 532);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(UIManager
	.getBorder("TitledBorder.border"), "My flights",
	TitledBorder.LEFT, TitledBorder.TOP, null, Color.GRAY));

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new LineBorder(Color.GRAY));

	JLabel labelLogo = new JLabel("");
	labelLogo.setIcon(new ImageIcon(AddFlight2.class
	.getResource("/images/smallLogo.png")));
	labelLogo.setBounds(10, 0, 69, 73);

	JButton buttonHome = new JButton("");
	buttonHome.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	ManageFlights home = new ManageFlights(user);
	home.setVisible(true);
	ModifyCancelFlight.this.setVisible(false);
	}
	});
	buttonHome.setIcon(new ImageIcon(ModifyCancelFlight.class
	.getResource("/images/blue-home-icon.png")));
	buttonHome.setBounds(10, 331, 160, 43);

	departureTime = new JTextField();
	departureTime.setEnabled(false);
	departureTime.setColumns(10);

	arrivalTime = new JTextField();
	arrivalTime.setEnabled(false);
	arrivalTime.setColumns(10);

	price = new JTextField();
	price.setEnabled(false);
	price.setColumns(10);

	JLabel label = new JLabel("Price");

	JLabel label_1 = new JLabel("Arrival time");

	JLabel label_2 = new JLabel("Departure time");

	departureDate = new JTextField();
	departureDate.setEnabled(false);
	departureDate.setColumns(10);

	JLabel label_3 = new JLabel("Departure date");

	JLabel label_4 = new JLabel("Arrival date");

	arrivalDate = new JTextField();
	arrivalDate.setEnabled(false);
	arrivalDate.setColumns(10);

	JLabel label_5 = new JLabel("Airline");

	airline = new JTextField();
	airline.setEnabled(false);
	airline.setColumns(10);

	nbSits = new JTextField();
	nbSits.setEnabled(false);
	nbSits.setColumns(10);

	JLabel label_6 = new JLabel("Number of sits");

	JLabel label_7 = new JLabel("Id");

	IdFlight = new JTextField();
	IdFlight.setEnabled(false);
	IdFlight.setColumns(10);

	JLabel label_8 = new JLabel("Flight number");

	numberFlight = new JTextField();
	numberFlight.setEnabled(false);
	numberFlight.setColumns(10);

	DepartureLocation = new JTextField();
	DepartureLocation.setEnabled(false);
	DepartureLocation.setColumns(10);

	JLabel label_9 = new JLabel("Departure location");

	JLabel label_10 = new JLabel("Arrival location");

	arrivalLocation = new JTextField();
	arrivalLocation.setEnabled(false);
	arrivalLocation.setColumns(10);

	JButton btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	Integer flightIdModif = (Integer) table.getValueAt(
	table.getSelectedRow(), 0);
	System.out.println("from " + flightIdModif);

	String from = (String) table.getValueAt(table.getSelectedRow(),
	2);
	System.out.println("from " + from);

	String to = (String) table.getValueAt(table.getSelectedRow(), 5);
	System.out.println("to " + to);

	String numFlight = (String) table.getValueAt(
	table.getSelectedRow(), 1);
	System.out.println("numFlight " + numFlight);

	Integer nbSitsArendre = (Integer) table.getValueAt(
	table.getSelectedRow(), 8);
	System.out.println("nbSitsArendre " + nbSitsArendre);

	JOptionPane
	.showMessageDialog(
	null,
	"You are going to see all our available flights matching your depature and arrival locations");
	ModifyFlight modifyFlight = new ModifyFlight(from, to,
	flightIdModif, numFlight, nbSitsArendre);
	modifyFlight.setVisible(true);
	ModifyCancelFlight.this.setVisible(false);
	}
	});
	btnUpdate.setIcon(new ImageIcon(ModifyCancelFlight.class
	.getResource("/images/updateFlight.png")));

	JButton btnCancel = new JButton("Delete");
	btnCancel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	FlightServicesDelegate.doDeleteFlight(flightSelected);
	flights = FlightServicesDelegate.doFindAllFlight();
	initDataBindings();

	IdFlight.setText("");
	airline.setText("");
	arrivalDate.setText("");
	arrivalLocation.setText("");
	arrivalTime.setText("");
	departureDate.setText("");
	DepartureLocation.setText("");
	departureTime.setText("");
	price.setText("");
	nbSits.setText("");
	numberFlight.setText("");

	// /////////////////Remise du nbSits � l'ancien
	// vol///////////////

	System.out.println("hello");
	String numF = (String) table.getValueAt(table.getSelectedRow(),
	1);
	System.out.println("numF = " + numF);
	FlightMatching flightMatch = FlightServicesDelegate
	.doFindFlightMatchingByNumFlight(numF);
	System.out.println("comp aer = " + flightMatch.getAirline());

	Integer nbFlightArendre = (Integer) table.getValueAt(
	table.getSelectedRow(), 8);
	System.out.println("nbFlightArendre = " + nbFlightArendre);
	System.out.println("comp aer = " + flightMatch.getAirline());

	flightMatch.setNumberOfSits(flightMatch.getNumberOfSits()
	+ nbFlightArendre);
	FlightServicesDelegate.doUpdateNbSits(flightMatch);
	System.out.println("Nv numF = " + flightMatch.getNumberOfSits());

	// /////////////////Remise du nbSits � l'ancien
	// vol///////////////

	SeeMyFlights seeMyFlights = new SeeMyFlights();
	seeMyFlights.setVisible(true);
	ModifyCancelFlight.this.setVisible(false);

	}
	});
	btnCancel.setIcon(new ImageIcon(ModifyCancelFlight.class
	.getResource("/images/deleteFlight.png")));

	JScrollPane scrollPane = new JScrollPane();
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
	Alignment.LEADING).addGroup(
	gl_panel.createSequentialGroup()
	.addContainerGap()
	.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
	638, Short.MAX_VALUE).addContainerGap()));
	gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
	Alignment.LEADING).addGroup(
	gl_panel.createSequentialGroup()
	.addGap(13)
	.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
	101, Short.MAX_VALUE).addContainerGap()));

	table = new JTable();
	scrollPane.setViewportView(table);
	panel.setLayout(gl_panel);

	JLabel lblModifyCancel = new JLabel("Modify - Cancel my flight");
	lblModifyCancel.setForeground(new Color(135, 206, 250));
	lblModifyCancel.setFont(new Font("Tahoma", Font.BOLD, 23));
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
	gl_contentPane
	.createSequentialGroup()
	.addContainerGap()
	.addComponent(
	panel_1,
	GroupLayout.PREFERRED_SIZE,
	775,
	Short.MAX_VALUE))
	.addGroup(
	gl_contentPane
	.createSequentialGroup()
	.addGap(10)
	.addComponent(
	labelLogo)
	.addGap(86)
	.addComponent(
	lblModifyCancel,
	GroupLayout.PREFERRED_SIZE,
	339,
	GroupLayout.PREFERRED_SIZE)
	.addPreferredGap(
	ComponentPlacement.RELATED,
	218,
	Short.MAX_VALUE)
	.addComponent(
	buttonHome,
	GroupLayout.PREFERRED_SIZE,
	63,
	GroupLayout.PREFERRED_SIZE)))
	.addContainerGap())
	.addGroup(
	gl_contentPane
	.createSequentialGroup()
	.addContainerGap(77, Short.MAX_VALUE)
	.addComponent(panel,
	GroupLayout.PREFERRED_SIZE,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.PREFERRED_SIZE)
	.addGap(48)));
	gl_contentPane
	.setVerticalGroup(gl_contentPane
	.createParallelGroup(Alignment.LEADING)
	.addGroup(
	gl_contentPane
	.createSequentialGroup()
	.addContainerGap()
	.addGroup(
	gl_contentPane
	.createParallelGroup(
	Alignment.LEADING)
	.addGroup(
	gl_contentPane
	.createParallelGroup(
	Alignment.LEADING,
	false)
	.addComponent(
	buttonHome,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.DEFAULT_SIZE,
	Short.MAX_VALUE)
	.addComponent(
	labelLogo,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.DEFAULT_SIZE,
	Short.MAX_VALUE))
	.addComponent(
	lblModifyCancel,
	GroupLayout.PREFERRED_SIZE,
	96,
	GroupLayout.PREFERRED_SIZE))
	.addPreferredGap(
	ComponentPlacement.RELATED)
	.addComponent(panel,
	GroupLayout.PREFERRED_SIZE,
	125, GroupLayout.PREFERRED_SIZE)
	.addGap(18)
	.addComponent(panel_1,
	GroupLayout.PREFERRED_SIZE,
	GroupLayout.DEFAULT_SIZE,
	GroupLayout.PREFERRED_SIZE)
	.addGap(46)));
	
	JButton btnBook = new JButton("Book");
	btnBook.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	gl_panel_1.setHorizontalGroup(
		gl_panel_1.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_1.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addComponent(label_10)
					.addComponent(label_9)
					.addComponent(label_8)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(numberFlight, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addGap(27)
						.addComponent(label_4)
						.addGap(18)
						.addComponent(arrivalDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addGap(22)
						.addComponent(label_1)
						.addGap(22)
						.addComponent(arrivalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnBook)
								.addGap(22)
								.addComponent(btnUpdate))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(IdFlight, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addComponent(label_3)
								.addGap(4)
								.addComponent(departureDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(22)
								.addComponent(label_2)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(4)
								.addComponent(departureTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(18)
								.addComponent(btnCancel))))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(arrivalLocation, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addComponent(DepartureLocation, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_5)
								.addGap(44)
								.addComponent(airline, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(label)
								.addGap(49)
								.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_6)
								.addGap(4)
								.addComponent(nbSits, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(78, Short.MAX_VALUE))
	);
	gl_panel_1.setVerticalGroup(
		gl_panel_1.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_1.createSequentialGroup()
				.addGap(25)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(label_7)
						.addGap(21)
						.addComponent(label_8)
						.addGap(21)
						.addComponent(label_9)
						.addGap(22)
						.addComponent(label_10))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(IdFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_3))
							.addComponent(departureDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_2))
							.addComponent(departureTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(numberFlight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(arrivalDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_1))
							.addComponent(arrivalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(DepartureLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addComponent(airline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label))
							.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(arrivalLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_6))
							.addComponent(nbSits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnUpdate)
							.addComponent(btnCancel)
							.addComponent(btnBook))))
				.addContainerGap(25, Short.MAX_VALUE))
	);
	panel_1.setLayout(gl_panel_1);
	contentPane.setLayout(gl_contentPane);
	initDataBindings();
	}
	
	
	
	protected void initDataBindings() {
	JTableBinding<Flight, List<Flight>, JTable> jTableBinding = SwingBindings
	.createJTableBinding(UpdateStrategy.READ_WRITE, flights, table);
	//
	BeanProperty<Flight, Integer> flightBeanProperty = BeanProperty
	.create("flightId");
	jTableBinding.addColumnBinding(flightBeanProperty, "Id flight")
	.setColumnName("Flight Id");
	//
	BeanProperty<Flight, String> flightBeanProperty_1 = BeanProperty
	.create("numFlight");
	jTableBinding.addColumnBinding(flightBeanProperty_1).setColumnName(
	"Flight number");
	//
	BeanProperty<Flight, String> flightBeanProperty_2 = BeanProperty
	.create("departureLocation");
	jTableBinding.addColumnBinding(flightBeanProperty_2).setColumnName(
	"Departure location");
	//
	BeanProperty<Flight, String> flightBeanProperty_3 = BeanProperty
	.create("departureDate");
	jTableBinding.addColumnBinding(flightBeanProperty_3).setColumnName(
	"Departure date");
	//
	BeanProperty<Flight, String> flightBeanProperty_4 = BeanProperty
	.create("timeFlightMatchingDep");
	jTableBinding.addColumnBinding(flightBeanProperty_4).setColumnName(
	"Departure time");
	//
	BeanProperty<Flight, String> flightBeanProperty_5 = BeanProperty
	.create("arrivalLocation");
	jTableBinding.addColumnBinding(flightBeanProperty_5).setColumnName(
	"Arrival location");
	//
	BeanProperty<Flight, String> flightBeanProperty_6 = BeanProperty
	.create("arrivalDate");
	jTableBinding.addColumnBinding(flightBeanProperty_6).setColumnName(
	"Arrival date");
	//
	BeanProperty<Flight, String> flightBeanProperty_7 = BeanProperty
	.create("timeFlightMatchingArr");
	jTableBinding.addColumnBinding(flightBeanProperty_7).setColumnName(
	"Arrival time");
	//
	BeanProperty<Flight, Integer> flightBeanProperty_8 = BeanProperty
	.create("nbSits");
	jTableBinding.addColumnBinding(flightBeanProperty_8).setColumnName(
	"Number sits reserved");
	//
	BeanProperty<Flight, String> flightBeanProperty_9 = BeanProperty
	.create("airline");
	jTableBinding.addColumnBinding(flightBeanProperty_9).setColumnName(
	"Airline");
	//
	BeanProperty<Flight, Double> flightBeanProperty_20 = BeanProperty
	.create("price");
	jTableBinding.addColumnBinding(flightBeanProperty_20).setColumnName(
	"Price");
	//
	jTableBinding.bind();
	//
	BeanProperty<JTable, Integer> jTableBeanProperty = BeanProperty
	.create("selectedElement.flightId");
	BeanProperty<Flight, Integer> flightBeanProperty_10 = BeanProperty
	.create("flightId");
	AutoBinding<JTable, Integer, Flight, Integer> autoBinding = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty, flightSelected,
	flightBeanProperty_10);
	autoBinding.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_1 = BeanProperty
	.create("selectedElement.departureLocation");
	BeanProperty<Flight, String> flightBeanProperty_11 = BeanProperty
	.create("departureLocation");
	AutoBinding<JTable, String, Flight, String> autoBinding_1 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_1, flightSelected,
	flightBeanProperty_11);
	autoBinding_1.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_2 = BeanProperty
	.create("selectedElement.departureDate");
	BeanProperty<Flight, String> flightBeanProperty_12 = BeanProperty
	.create("departureDate");
	AutoBinding<JTable, String, Flight, String> autoBinding_2 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_2, flightSelected,
	flightBeanProperty_12);
	autoBinding_2.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_3 = BeanProperty
	.create("selectedElement.timeFlightMatchingDep");
	BeanProperty<Flight, String> flightBeanProperty_13 = BeanProperty
	.create("timeFlightMatchingDep");
	AutoBinding<JTable, String, Flight, String> autoBinding_3 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_3, flightSelected,
	flightBeanProperty_13);
	autoBinding_3.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_4 = BeanProperty
	.create("selectedElement.arrivalLocation");
	BeanProperty<Flight, String> flightBeanProperty_14 = BeanProperty
	.create("arrivalLocation");
	AutoBinding<JTable, String, Flight, String> autoBinding_4 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_4, flightSelected,
	flightBeanProperty_14);
	autoBinding_4.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_5 = BeanProperty
	.create("selectedElement.arrivalDate");
	BeanProperty<Flight, String> flightBeanProperty_15 = BeanProperty
	.create("arrivalDate");
	AutoBinding<JTable, String, Flight, String> autoBinding_5 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_5, flightSelected,
	flightBeanProperty_15);
	autoBinding_5.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_6 = BeanProperty
	.create("selectedElement.timeFlightMatchingArr");
	BeanProperty<Flight, String> flightBeanProperty_16 = BeanProperty
	.create("timeFlightMatchingArr");
	AutoBinding<JTable, String, Flight, String> autoBinding_6 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_6, flightSelected,
	flightBeanProperty_16);
	autoBinding_6.bind();
	//
	BeanProperty<JTable, Integer> jTableBeanProperty_7 = BeanProperty
	.create("selectedElement.nbSits");
	BeanProperty<Flight, Integer> flightBeanProperty_17 = BeanProperty
	.create("nbSits");
	AutoBinding<JTable, Integer, Flight, Integer> autoBinding_7 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_7, flightSelected,
	flightBeanProperty_17);
	autoBinding_7.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_8 = BeanProperty
	.create("selectedElement.airline");
	BeanProperty<Flight, String> flightBeanProperty_18 = BeanProperty
	.create("airline");
	AutoBinding<JTable, String, Flight, String> autoBinding_8 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_8, flightSelected,
	flightBeanProperty_18);
	autoBinding_8.bind();
	//
	BeanProperty<JTable, Double> jTableBeanProperty_9 = BeanProperty
	.create("selectedElement.price");
	BeanProperty<Flight, Double> flightBeanProperty_19 = BeanProperty
	.create("price");
	AutoBinding<JTable, Double, Flight, Double> autoBinding_9 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_9, flightSelected,
	flightBeanProperty_19);
	autoBinding_9.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
	.create("text");
	AutoBinding<Flight, Integer, JTextField, String> autoBinding_10 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_10, IdFlight, jTextFieldBeanProperty);
	autoBinding_10.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_11 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_13, departureTime,
	jTextFieldBeanProperty_1);
	autoBinding_11.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_12 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_16, arrivalTime,
	jTextFieldBeanProperty_2);
	autoBinding_12.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty
	.create("text");
	AutoBinding<Flight, Double, JTextField, String> autoBinding_13 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_19, price, jTextFieldBeanProperty_3);
	autoBinding_13.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_14 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_12, departureDate,
	jTextFieldBeanProperty_4);
	autoBinding_14.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_15 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_15, arrivalDate,
	jTextFieldBeanProperty_5);
	autoBinding_15.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_16 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_18, airline,
	jTextFieldBeanProperty_6);
	autoBinding_16.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty
	.create("text");
	AutoBinding<Flight, Integer, JTextField, String> autoBinding_17 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_17, nbSits, jTextFieldBeanProperty_7);
	autoBinding_17.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_8 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_18 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_11, DepartureLocation,
	jTextFieldBeanProperty_8);
	autoBinding_18.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_9 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_19 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_14, arrivalLocation,
	jTextFieldBeanProperty_9);
	autoBinding_19.bind();
	//
	BeanProperty<JTable, String> jTableBeanProperty_10 = BeanProperty
	.create("selectedElement.numFlight");
	BeanProperty<Flight, String> flightBeanProperty_21 = BeanProperty
	.create("numFlight");
	AutoBinding<JTable, String, Flight, String> autoBinding_20 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, table,
	jTableBeanProperty_10, flightSelected,
	flightBeanProperty_21);
	autoBinding_20.bind();
	//
	BeanProperty<JTextField, String> jTextFieldBeanProperty_10 = BeanProperty
	.create("text");
	AutoBinding<Flight, String, JTextField, String> autoBinding_21 = Bindings
	.createAutoBinding(UpdateStrategy.READ_WRITE, flightSelected,
	flightBeanProperty_21, numberFlight,
	jTextFieldBeanProperty_10);
	autoBinding_21.bind();
	}
}