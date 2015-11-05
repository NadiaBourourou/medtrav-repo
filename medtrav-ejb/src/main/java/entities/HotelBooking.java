package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HotelBooking
 *
 */
@Entity

public class HotelBooking implements Serializable {

	private Integer hotelBookingId;
	private Double numNights;
	private Double price;
	private Hotel hotel;
	
	private static final long serialVersionUID = 1L;

	public HotelBooking() {
		super();
	}

	public HotelBooking(Double numNights, Double price, Hotel hotel) {
		super();
		this.numNights = numNights;
		this.price = price;
		this.hotel = hotel;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getHotelBookingId() {
		return hotelBookingId;
	}

	public void setHotelBookingId(Integer hotelBookingId) {
		this.hotelBookingId = hotelBookingId;
	}

	public Double getNumNights() {
		return numNights;
	}

	public void setNumNights(Double numNights) {
		this.numNights = numNights;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}




   
}
