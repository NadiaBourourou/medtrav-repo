package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity
@Table(name = "T_BOOKING")
public class Booking implements Serializable {

	private Integer bookingId;

	private StateBooking state;

	private Flight flight;
	private HotelBooking hotelBooking;
	private ClinicBooking clinicBooking;
	private SurgeryPatient surgeryPatient;
	private DoctorPatient doctorPatient;

	private static final long serialVersionUID = 1L;

	public Booking() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	@ManyToOne
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public StateBooking getState() {
		return state;
	}

	public void setState(StateBooking state) {
		this.state = state;
	}

	@ManyToOne
	public HotelBooking getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(HotelBooking hotelBooking) {
		this.hotelBooking = hotelBooking;
	}

	@ManyToOne
	public ClinicBooking getClinicBooking() {
		return clinicBooking;
	}

	public void setClinicBooking(ClinicBooking clinicBooking) {
		this.clinicBooking = clinicBooking;
	}

	@ManyToOne
	public SurgeryPatient getSurgeryPatient() {
		return surgeryPatient;
	}

	public void setSurgeryPatient(SurgeryPatient surgeryPatient) {
		this.surgeryPatient = surgeryPatient;
	}

	@ManyToOne
	public DoctorPatient getDoctorPatient() {
		return doctorPatient;
	}

	public void setDoctorPatient(DoctorPatient doctorPatient) {
		this.doctorPatient = doctorPatient;
	}

}
