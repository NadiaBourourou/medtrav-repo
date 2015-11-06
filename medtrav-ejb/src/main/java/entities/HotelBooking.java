package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: HotelBooking
 *
 */
@Entity
public class HotelBooking implements Serializable {

	private HotelBookingID hotelBookingId;
	private Integer numNights;
	private Double price;
	private RoomType roomType;
	private Hotel hotel;

	private static final long serialVersionUID = 1L;

	private Patient patient;
	private Booking booking;

	public HotelBooking() {
		super();
	}


	
	public HotelBooking(Integer numNights, Double price, RoomType roomType, Hotel hotel, Patient patient) {
		super();
		this.hotelBookingId = new HotelBookingID (hotel.getHotelId(),
				patient.getUserId());
		this.numNights = numNights;
		this.price = price;
		this.roomType=roomType;
		this.hotel = hotel;
		this.patient = patient;
	}



	@EmbeddedId
	public HotelBookingID getHotelBookingId() {
		return hotelBookingId;
	}

	public void setHotelBookingId(HotelBookingID hotelBookingId) {
		this.hotelBookingId = hotelBookingId;
	}

	public Integer getNumNights() {
		return numNights;
	}

	public void setNumNights(Integer numNights) {
		this.numNights = numNights;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	


	public RoomType getRoomType() {
		return roomType;
	}



	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}



	@ManyToOne
	@JoinColumn(name = "hotelId", referencedColumnName = "hotelId", insertable = false, updatable = false)

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "userId", insertable = false, updatable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	

	@OneToOne(mappedBy = "hotelBooking")
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
