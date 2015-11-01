package entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name="T_FLIGHT")
public class Flight implements Serializable {

	
	private Integer flightId;
	private Date departureDate;
	private Date arrivalDate;
	private String departureLocation;
	private String arrivalLocation;
	private Double price;
	
	private List<Booking> bookings;
	
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFlightId() {
		return this.flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}   
	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}   
	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}   
	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}   
	public String getArrivalLocation() {
		return this.arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@OneToMany(mappedBy="flight")
	public List<Booking> getBookings() {
		return bookings;
	}
	
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public void linkBookingsToThisFlight(List<Booking> bookings) {
		this.bookings = bookings;
		for (Booking b : bookings) {
			b.setFlight(this);
		}
		
	}
   
}
