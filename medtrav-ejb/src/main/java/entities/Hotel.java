package entities;



import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;
import javax.swing.ImageIcon;


/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@Table(name="T_HOTEL")
public class Hotel implements Serializable {

	private Integer hotelId;
	private String name;
	private String description;
	private String address;
	private StateType state;
	private Double priceSingle;
	private Double priceSuite;
	private RoomType room;
	private Integer stars;
	//private  byte[] pic;
	private List<Booking> bookings;
	private List<HotelBooking> hotelBookings;
	

	private static final long serialVersionUID = 1L;
	
	
	
	
	public Hotel() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	

	public Double getPriceSingle() {
		return priceSingle;
	}

	public void setPriceSingle(Double priceSingle) {
		this.priceSingle = priceSingle;
	}

	public Double getPriceSuite() {
		return priceSuite;
	}
	public void setPriceSuite(Double priceSuite) {
		this.priceSuite = priceSuite;
	}
	public RoomType getRoom() {
		return room;
	}

	public void setRoom(RoomType room) {
		this.room = room;
	}


	public Integer getStars() {
		return this.stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	//@Lob
	//public byte[] getPic() {
		//return pic;
//	}
	//public void setPic(byte[] pic) {
		//this.pic = pic;
//	}

	
	
	@OneToMany(mappedBy="hotel")
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	@OneToMany(mappedBy="hotel")
	public List<HotelBooking> getHotelBookings() {
		return hotelBookings;
	}
	public void setHotelBookings(List<HotelBooking> hotelBookings) {
		this.hotelBookings = hotelBookings;
	}
	

	
}
