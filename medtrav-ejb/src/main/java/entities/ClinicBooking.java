package entities;

import entities.RoomClinicType;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClinicBooking
 *
 */
@Entity

public class ClinicBooking implements Serializable {

	
	private Integer clinicBookingId;
	private RoomClinicType typeRoom;
	private String date;
	private String commentaire;
	private Double price;
	private static final long serialVersionUID = 1L;
	private Clinic clinic;
	private Patient patient;
	private Booking booking;
	

	
	public ClinicBooking() {
		super();
	}   
	@Id    
	public Integer getClinicBookingId() {
		return this.clinicBookingId;
	}

	public void setClinicBookingId(Integer clinicBookingId) {
		this.clinicBookingId = clinicBookingId;
	}   
	public RoomClinicType getTypeRoom() {
		return this.typeRoom;
	}

	public void setTypeRoom(RoomClinicType typeRoom) {
		this.typeRoom = typeRoom;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@ManyToOne
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	@OneToOne
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@OneToOne(mappedBy = "clinicBooking")
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
   
}
