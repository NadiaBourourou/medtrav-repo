package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ObjectProperty;

import delegates.BookingServicesDelegate;
import entities.Booking;
import entities.Clinic;
import entities.ClinicBooking;
import entities.ClinicBookingID;
import entities.DoctorPatient;
import entities.Flight;
import entities.Hotel;
import entities.HotelBooking;
import entities.HotelBookingID;
import entities.StateBooking;
import entities.Surgery;
import entities.SurgeryPatient;
import entities.User;
import gui.flights.ManageFlights;

public class Book extends JFrame {

	private Hotel hotel = new Hotel();
	private Booking booking = new Booking();
	private Flight flight = new Flight();
	private Clinic clinic = new Clinic();
	private Surgery surgery = new Surgery();
	private SurgeryPatient surgeryPatient = new SurgeryPatient();
	private DoctorPatient doctorPatient = new DoctorPatient();
	private HotelBooking hotelBooking = new HotelBooking();
	private HotelBookingID hotelBookingID = new HotelBookingID();
	private ClinicBooking clinicBooking = new ClinicBooking();
	private ClinicBookingID clinicBookingID = new ClinicBookingID();

	private JPanel contentPane;
	private JTextField thotel;
	private JTextField tclinic;
	private JTextField tsurgery;
	private JTextField arrival;
	private JTextField departure;
	private JTextField tdoctor;
	JComboBox etatCombo = new JComboBox();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
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
	public Book() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		thotel = new JTextField();
		thotel.setBounds(95, 127, 86, 20);
		thotel.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(15, 77, 70, 70);
		label.setIcon(new ImageIcon(Book.class
				.getResource("/images/hotel-service_318-29285.jpg")));

		JLabel lblHotel = new JLabel("Hotel ");
		lblHotel.setBounds(95, 90, 56, 14);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(15, 243, 70, 70);
		label_1.setIcon(new ImageIcon(
				Book.class
						.getResource("/images/hospital_medicine_health_healthcare_medical-512.png")));

		JLabel lblClinic = new JLabel("Clinic");
		lblClinic.setBounds(95, 243, 56, 14);

		tclinic = new JTextField();
		tclinic.setBounds(95, 282, 86, 20);
		tclinic.setColumns(10);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(248, 77, 70, 70);
		label_2.setIcon(new ImageIcon(Book.class
				.getResource("/images/operating-room-theatre-256.png")));

		JLabel lblSurgery = new JLabel("Surgery");
		lblSurgery.setBounds(328, 90, 56, 14);

		tsurgery = new JTextField();
		tsurgery.setBounds(331, 127, 86, 20);
		tsurgery.setColumns(10);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(238, 226, 65, 76);
		label_3.setIcon(new ImageIcon(Book.class
				.getResource("/images/Flight_icon.png")));

		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(331, 176, 56, 14);

		arrival = new JTextField();
		arrival.setBounds(313, 226, 86, 20);
		arrival.setColumns(10);

		departure = new JTextField();
		departure.setBounds(313, 282, 86, 20);
		departure.setColumns(10);

		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(316, 201, 56, 14);

		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(313, 257, 81, 14);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(456, 90, 70, 70);
		label_4.setIcon(new ImageIcon(Book.class
				.getResource("/images/doctorb.png")));

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(536, 90, 56, 14);

		tdoctor = new JTextField();
		tdoctor.setBounds(536, 127, 86, 20);
		tdoctor.setColumns(10);

		JButton btnChangeHotel = new JButton("Change hotel");
		btnChangeHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ChooseTheHotel frameChooseHotel = new ChooseTheHotel();
				frameChooseHotel.setVisible(true);

			}
		});
		btnChangeHotel.setBounds(57, 172, 124, 23);
		contentPane.setLayout(null);
		contentPane.add(label_4);
		contentPane.add(lblDoctor);
		contentPane.add(tdoctor);
		contentPane.add(btnChangeHotel);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(tclinic);
		contentPane.add(lblClinic);
		contentPane.add(thotel);
		contentPane.add(lblHotel);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(lblSurgery);
		contentPane.add(lblFlight);
		contentPane.add(lblArrival);
		contentPane.add(arrival);
		contentPane.add(lblDeparture);
		contentPane.add(departure);
		contentPane.add(tsurgery);

		JButton btnChangeClinic = new JButton("Change clinic");
		btnChangeClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ChooseClinic chooseClinic = new ChooseClinic();
				chooseClinic.setVisible(true);
			}
		});
		btnChangeClinic.setBounds(77, 317, 124, 23);
		contentPane.add(btnChangeClinic);

		JButton btnChangeFlight = new JButton("Change flight");
		btnChangeFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChangeFlight.setBounds(293, 317, 124, 23);
		contentPane.add(btnChangeFlight);

		JButton btnBook = new JButton("");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				StateBooking state = null;
				booking.setState(state.CONFIRMED);

				if (etatCombo.getSelectedIndex() == 0) {
					// hotel
					hotelBooking = BookingServicesDelegate
							.doFindHotelBookingByPatientId(1);
					booking.setHotelBooking(hotelBooking);

					// Clinic
					clinicBooking = BookingServicesDelegate
							.doFindClinicBookingByPatientId(1);
					booking.setClinicBooking(clinicBooking);

					// Surgery
					surgeryPatient = BookingServicesDelegate
							.doFindSurgeryPatientByPatientId(1);
					booking.setSurgeryPatient(surgeryPatient);

					// Doctor
					doctorPatient = BookingServicesDelegate
							.doFindDoctorPatientByPatientId(1);
					booking.setDoctorPatient(doctorPatient);

					// Flight
					flight = BookingServicesDelegate.doFindFlightByPatientId(1);
					booking.setFlight(flight);

					BookingServicesDelegate.doAddBooking(booking);
					JOptionPane.showMessageDialog(null,
							"Booking added successfully ");
				}

			}
		});
		btnBook.setIcon(new ImageIcon(Book.class.getResource("/images/reserver.png")));
		btnBook.setBounds(456, 319, 56, 62);
		contentPane.add(btnBook);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Hotel
				hotelBooking = BookingServicesDelegate
						.doFindHotelBookingByPatientId(1);
				thotel.setText(hotelBooking.getHotel().getName());

				// Clinic
				clinicBooking = BookingServicesDelegate
						.doFindClinicBookingByPatientId(1);
				tclinic.setText(clinicBooking.getClinic().getName());

				// Surgery
				surgeryPatient = BookingServicesDelegate
						.doFindSurgeryPatientByPatientId(1);
				tsurgery.setText(surgeryPatient.getSurgery().getName());

				// Doctor
				doctorPatient = BookingServicesDelegate
						.doFindDoctorPatientByPatientId(1);
				tdoctor.setText(doctorPatient.getDoctor().getLastName() + "  "
						+ doctorPatient.getDoctor().getFirstName());

				// Flight
				flight = BookingServicesDelegate.doFindFlightByPatientId(1);

				String arrive =  flight.getArrivalDate();
				String depart = flight.getDepartureDate();

				/*SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");

				String dateArriveString = null;
				String dateDepartString = null;

				dateArriveString = sdfr.format(arrive);
				dateDepartString = sdfr.format(depart);*/

				arrival.setText(arrive);
				departure.setText(depart);

			}
		});
		button.setIcon(new ImageIcon(Book.class
				.getResource("/images/d\u00E9tails.jpg")));
		button.setBounds(194, 351, 124, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (etatCombo.getSelectedIndex() == 1) {
					StateBooking state = null;
					booking = BookingServicesDelegate
							.doFindBookingByPatientId(1);
					booking.setState(state.POSTPONED);
					BookingServicesDelegate.doUpdateBooking(booking);
					JOptionPane.showMessageDialog(null,
							"Booking updated succefully");

				} else {
					JOptionPane.showMessageDialog(null,
							"Please check your request");

				}
			}
		});
		button_1.setIcon(new ImageIcon(Book.class.getResource("/images/modifier.png")));
		button_1.setBounds(531, 319, 56, 62);
		contentPane.add(button_1);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				booking = BookingServicesDelegate.doFindBookingByPatientId(1);
				BookingServicesDelegate.doDeleteBookingByPatientId(booking);
				JOptionPane.showMessageDialog(null,
						"Are you sure you want to delete your Booking");

			}
		});
		button_2.setIcon(new ImageIcon(Book.class.getResource("/images/supprimer.png")));
		button_2.setBounds(609, 319, 56, 62);
		contentPane.add(button_2);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(469, 214, 56, 14);
		contentPane.add(lblState);

		etatCombo.setModel(new DefaultComboBoxModel(StateBooking.values()));
		etatCombo.setBounds(535, 211, 108, 20);
		contentPane.add(etatCombo);
		initDataBindings();
	}
	
	
	public Book(User user) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		thotel = new JTextField();
		thotel.setBounds(95, 127, 86, 20);
		thotel.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(15, 77, 70, 70);
		label.setIcon(new ImageIcon(Book.class
				.getResource("/images/hotel-service_318-29285.jpg")));

		JLabel lblHotel = new JLabel("Hotel ");
		lblHotel.setBounds(95, 90, 56, 14);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(15, 243, 70, 70);
		label_1.setIcon(new ImageIcon(
				Book.class
						.getResource("/images/hospital_medicine_health_healthcare_medical-512.png")));

		JLabel lblClinic = new JLabel("Clinic");
		lblClinic.setBounds(95, 243, 56, 14);

		tclinic = new JTextField();
		tclinic.setBounds(95, 282, 86, 20);
		tclinic.setColumns(10);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(248, 77, 70, 70);
		label_2.setIcon(new ImageIcon(Book.class
				.getResource("/images/operating-room-theatre-256.png")));

		JLabel lblSurgery = new JLabel("Surgery");
		lblSurgery.setBounds(328, 90, 56, 14);

		tsurgery = new JTextField();
		tsurgery.setBounds(331, 127, 86, 20);
		tsurgery.setColumns(10);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(238, 226, 65, 76);
		label_3.setIcon(new ImageIcon(Book.class
				.getResource("/images/Flight_icon.png")));

		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(331, 176, 56, 14);

		arrival = new JTextField();
		arrival.setBounds(313, 226, 86, 20);
		arrival.setColumns(10);

		departure = new JTextField();
		departure.setBounds(313, 282, 86, 20);
		departure.setColumns(10);

		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(316, 201, 56, 14);

		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(313, 257, 81, 14);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(456, 90, 70, 70);
		label_4.setIcon(new ImageIcon(Book.class
				.getResource("/images/doctorb.png")));

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(536, 90, 56, 14);

		tdoctor = new JTextField();
		tdoctor.setBounds(536, 127, 86, 20);
		tdoctor.setColumns(10);

		JButton btnChangeHotel = new JButton("Change hotel");
		btnChangeHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ChooseTheHotel frameChooseHotel = new ChooseTheHotel(user);
				frameChooseHotel.setVisible(true);

			}
		});
		btnChangeHotel.setBounds(57, 172, 124, 23);
		contentPane.setLayout(null);
		contentPane.add(label_4);
		contentPane.add(lblDoctor);
		contentPane.add(tdoctor);
		contentPane.add(btnChangeHotel);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(tclinic);
		contentPane.add(lblClinic);
		contentPane.add(thotel);
		contentPane.add(lblHotel);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(lblSurgery);
		contentPane.add(lblFlight);
		contentPane.add(lblArrival);
		contentPane.add(arrival);
		contentPane.add(lblDeparture);
		contentPane.add(departure);
		contentPane.add(tsurgery);

		JButton btnChangeClinic = new JButton("Change clinic");
		btnChangeClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ChooseClinic chooseClinic = new ChooseClinic(user);
				chooseClinic.setVisible(true);
			}
		});
		btnChangeClinic.setBounds(77, 317, 124, 23);
		contentPane.add(btnChangeClinic);

		JButton btnChangeFlight = new JButton("Change flight");
		btnChangeFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ManageFlights manageFlights = new ManageFlights();
				manageFlights.setVisible(true);
				
				
			}
		});
		btnChangeFlight.setBounds(293, 317, 124, 23);
		contentPane.add(btnChangeFlight);

		JButton btnBook = new JButton("");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				StateBooking state = null;
				booking.setState(state.CONFIRMED);

				if (etatCombo.getSelectedIndex() == 0) {
					// hotel
					hotelBooking = BookingServicesDelegate
							.doFindHotelBookingByPatientId(user.getUserId());
					booking.setHotelBooking(hotelBooking);

					// Clinic
					clinicBooking = BookingServicesDelegate
							.doFindClinicBookingByPatientId(user.getUserId());
					booking.setClinicBooking(clinicBooking);

					// Surgery
					surgeryPatient = BookingServicesDelegate
							.doFindSurgeryPatientByPatientId(user.getUserId());
					booking.setSurgeryPatient(surgeryPatient);

					// Doctor
					doctorPatient = BookingServicesDelegate
							.doFindDoctorPatientByPatientId(user.getUserId());
					booking.setDoctorPatient(doctorPatient);

					// Flight
					flight = BookingServicesDelegate.doFindFlightByPatientId(user.getUserId());
					booking.setFlight(flight);

					BookingServicesDelegate.doAddBooking(booking);
					JOptionPane.showMessageDialog(null,
							"Booking added successfully ");
				}

			}
		});
		btnBook.setIcon(new ImageIcon(Book.class.getResource("/images/reserver.png")));
		btnBook.setBounds(456, 319, 56, 62);
		contentPane.add(btnBook);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Hotel
				hotelBooking = BookingServicesDelegate
						.doFindHotelBookingByPatientId(user.getUserId());
				thotel.setText(hotelBooking.getHotel().getName());

				// Clinic
				clinicBooking = BookingServicesDelegate
						.doFindClinicBookingByPatientId(user.getUserId());
				tclinic.setText(clinicBooking.getClinic().getName());

				// Surgery
				surgeryPatient = BookingServicesDelegate
						.doFindSurgeryPatientByPatientId(user.getUserId());
				tsurgery.setText(surgeryPatient.getSurgery().getName());

				// Doctor
				doctorPatient = BookingServicesDelegate
						.doFindDoctorPatientByPatientId(user.getUserId());
				tdoctor.setText(doctorPatient.getDoctor().getLastName() + "  "
						+ doctorPatient.getDoctor().getFirstName());

				// Flight
				flight = BookingServicesDelegate.doFindFlightByPatientId(user.getUserId());

				String arrive =  flight.getArrivalDate();
				String depart = flight.getDepartureDate();

				/*SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");

				String dateArriveString = null;
				String dateDepartString = null;

				dateArriveString = sdfr.format(arrive);
				dateDepartString = sdfr.format(depart);*/

				arrival.setText(arrive);
				departure.setText(depart);

			}
		});
		button.setIcon(new ImageIcon(Book.class
				.getResource("/images/d\u00E9tails.jpg")));
		button.setBounds(194, 351, 124, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (etatCombo.getSelectedIndex() == 1) {
					StateBooking state = null;
					booking = BookingServicesDelegate
							.doFindBookingByPatientId(user.getUserId());
					booking.setState(state.POSTPONED);
					BookingServicesDelegate.doUpdateBooking(booking);
					JOptionPane.showMessageDialog(null,
							"Booking updated succefully");

				} else {
					JOptionPane.showMessageDialog(null,
							"Please check your request");

				}
			}
		});
		button_1.setIcon(new ImageIcon(Book.class.getResource("/images/modifier.png")));
		button_1.setBounds(531, 319, 56, 62);
		contentPane.add(button_1);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				booking = BookingServicesDelegate.doFindBookingByPatientId(user.getUserId());
				BookingServicesDelegate.doDeleteBookingByPatientId(booking);
				JOptionPane.showMessageDialog(null,
						"Are you sure you want to delete your Booking");

			}
		});
		button_2.setIcon(new ImageIcon(Book.class.getResource("/images/supprimer.png")));
		button_2.setBounds(609, 319, 56, 62);
		contentPane.add(button_2);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(469, 214, 56, 14);
		contentPane.add(lblState);

		etatCombo.setModel(new DefaultComboBoxModel(StateBooking.values()));
		etatCombo.setBounds(535, 211, 108, 20);
		contentPane.add(etatCombo);
		initDataBindings();
	}

	protected void initDataBindings() {
		ObjectProperty<JTextField> jTextFieldObjectProperty = ObjectProperty
				.create();
		AutoBinding<Hotel, Hotel, JTextField, JTextField> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, hotel, thotel,
						jTextFieldObjectProperty);
		autoBinding.bind();
	}
}
