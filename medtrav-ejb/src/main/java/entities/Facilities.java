package entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Facilities
 *
 */
@Entity

public class Facilities implements Serializable {

	
	private Integer facilitiesId;
	private String name;
	private String description;
	private String address;
	private StateType state;
	private Integer numNights;
	private Double price;
	private RoomType room;
	private static final long serialVersionUID = 1L;

	public Facilities() {
		super();
	}   
	@Id    
	public Integer getFacilitiesId() {
		return this.facilitiesId;
	}

	public void setFacilitiesId(Integer facilitiesId) {
		this.facilitiesId = facilitiesId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public StateType getState() {
		return this.state;
	}

	public void setState(StateType state) {
		this.state = state;
	}   
	public Integer getNumNights() {
		return this.numNights;
	}

	public void setNumNights(Integer numNights) {
		this.numNights = numNights;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}   
	public RoomType getRoom() {
		return this.room;
	}

	public void setRoom(RoomType room) {
		this.room = room;
	}
   
}