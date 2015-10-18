package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity
@Table(name="T_BOOKING")
public class Booking implements Serializable {

	public StateBooking getState() {
		return state;
	}


	public void setState(StateBooking state) {
		this.state = state;
	}

	private Integer bookingId;
	private Date arrival;
	private Date departure;
	private StateBooking state;
	
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
	
	
   
}
