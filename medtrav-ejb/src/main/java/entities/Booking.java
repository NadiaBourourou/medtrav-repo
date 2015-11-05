package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity
@Table(name = "T_BOOKING")
public class Booking implements Serializable {

	private Integer bookingId;
	private Date arrival;
	private Date departure;
	private StateBooking state;
	
	private Hotel hotel;
	private Clinic clinic;
	private Patient patient;
	private Flight flight;
	private HotelBooking hotelBooking;

	private static final long serialVersionUID = 1L;

	public Booking() {
		super();
	}

	public Booking(Date arrival, Date departure) {
		super();
		this.arrival = arrival;
		this.departure = departure;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}


	@ManyToOne
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@ManyToOne
	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	@OneToOne
	public HotelBooking getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(HotelBooking hotelBooking) {
		this.hotelBooking = hotelBooking;
	}

}
