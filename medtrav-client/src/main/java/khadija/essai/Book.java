package khadija.essai;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import entities.Flight;
import entities.Hotel;
import entities.HotelBooking;
import entities.HotelBookingID;
import entities.Patient;
import entities.StateBooking;
import entities.SurgeryPatient;

public class Book extends JFrame {

	private Hotel hotel = new Hotel();
	private Booking booking = new Booking();
	private Flight flight = new Flight();
	private Clinic clinic = new Clinic();
	private HotelBooking hotelBooking = new HotelBooking();
	private HotelBookingID hotelBookingID = new HotelBookingID();
	private ClinicBooking clinicBooking = new ClinicBooking();
	private ClinicBookingID clinicBookingID = new ClinicBookingID();

	private JPanel contentPane;
	private JTextField thotel;
	private JTextField tclinic;
	private JTextField tsurgery;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 641, 366);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		thotel = new JTextField();
		thotel.setBounds(95, 49, 86, 20);
		thotel.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(15, 17, 70, 70);
		label.setIcon(new ImageIcon(Book.class
				.getResource("/images/hotel-service_318-29285.jpg")));

		JLabel lblHotel = new JLabel("Hotel ");
		lblHotel.setBounds(95, 17, 56, 14);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(15, 143, 70, 70);
		label_1.setIcon(new ImageIcon(
				Book.class
						.getResource("/images/hospital_medicine_health_healthcare_medical-512.png")));

		JLabel lblClinic = new JLabel("Clinic");
		lblClinic.setBounds(95, 143, 56, 14);

		tclinic = new JTextField();
		tclinic.setBounds(95, 183, 86, 20);
		tclinic.setColumns(10);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(238, 17, 70, 70);
		label_2.setIcon(new ImageIcon(Book.class
				.getResource("/images/operating-room-theatre-256.png")));

		JLabel lblSurgery = new JLabel("Surgery");
		lblSurgery.setBounds(331, 17, 56, 14);

		tsurgery = new JTextField();
		tsurgery.setBounds(331, 49, 86, 20);
		tsurgery.setColumns(10);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(238, 127, 65, 76);
		label_3.setIcon(new ImageIcon(Book.class
				.getResource("/images/Flight_icon.png")));

		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(343, 102, 56, 14);

		textField_3 = new JTextField();
		textField_3.setBounds(313, 143, 86, 20);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(313, 193, 86, 20);
		textField_4.setColumns(10);

		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(314, 127, 56, 14);

		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(313, 173, 81, 14);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(507, 17, 70, 70);
		label_4.setIcon(new ImageIcon(Book.class
				.getResource("/images/doctorb.png")));

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(587, 17, 56, 14);

		textField_5 = new JTextField();
		textField_5.setBounds(587, 49, 86, 20);
		textField_5.setColumns(10);

		JButton btnChangeHotel = new JButton("Change hotel");
		btnChangeHotel.setBounds(95, 93, 124, 23);
		contentPane.setLayout(null);
		contentPane.add(label_4);
		contentPane.add(lblDoctor);
		contentPane.add(textField_5);
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
		contentPane.add(textField_3);
		contentPane.add(lblDeparture);
		contentPane.add(textField_4);
		contentPane.add(tsurgery);

		JButton btnChangeClinic = new JButton("Change clinic");
		btnChangeClinic.setBounds(95, 224, 124, 23);
		contentPane.add(btnChangeClinic);

		JButton btnChangeFlight = new JButton("Change flight");
		btnChangeFlight.setBounds(293, 224, 124, 23);
		contentPane.add(btnChangeFlight);

		JButton btnBook = new JButton("");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				StateBooking state = null;
				booking.setState(state.CONFIRMED);
				SurgeryPatient sp = new SurgeryPatient();
				Patient p = new Patient();
				p.setUserId(1);

				hotel = BookingServicesDelegate.doFindHotelByPatientId(1);
				int hotelId = hotel.getHotelId();
				hotelBookingID.sethotelId(hotelId);
				hotelBookingID.setpatientId(1);
				hotelBooking.setHotelBookingId(hotelBookingID);
				// Clinic
				clinic = BookingServicesDelegate.doFindClinicByPatientId(1);
				int clinicId = clinic.getClinicId();
				clinicBookingID.setClinicId(clinicId);
				clinicBookingID.setPatientId(1);
				clinicBooking.setClinicBookingId(clinicBookingID);

				booking.setHotelBooking(hotelBooking);
				booking.setClinicBooking(clinicBooking);

				BookingServicesDelegate.doAddBooking(booking);

				System.out.println(hotelId);
				System.out.println(clinicId);

			}
		});
		btnBook.setIcon(new ImageIcon(Book.class
				.getResource("/images/book-now-icon.png")));
		btnBook.setBounds(507, 207, 86, 85);
		contentPane.add(btnBook);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Hotel
				hotel = BookingServicesDelegate.doFindHotelByPatientId(1);
				int hotelId = hotel.getHotelId();
				thotel.setText(hotel.getName());

				// Clinic
				clinic = BookingServicesDelegate.doFindClinicByPatientId(1);
				int clinicId = clinic.getClinicId();
				tclinic.setText(clinic.getName());

				/*
				 * flight = FlightServicesDelegate.doFindFlightByPatientId(1);
				 * Date arrive = (Date) flight.getArrivalDate();
				 */

			}
		});
		button.setIcon(new ImageIcon(Book.class
				.getResource("/images/d\u00E9tails.jpg")));
		button.setBounds(184, 279, 124, 23);
		contentPane.add(button);
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
