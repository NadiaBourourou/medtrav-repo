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

	
	private ClinicBookingID clinicBookingId;
	private RoomClinicType typeRoom;
	private String date;
	private String commentaire;
	private static final long serialVersionUID = 1L;
	private Clinic clinic;
	private Patient patient;
	private Booking booking;
	

	
	public ClinicBooking() {
		super();
	}   
	
	
	public ClinicBooking(RoomClinicType typeRoom, String date,
			String commentaire, Clinic clinic, Patient patient) {
		super();
		this.clinicBookingId = new ClinicBookingID (clinic.getClinicId(),
				patient.getUserId());
		this.typeRoom = typeRoom;
		this.date = date;
		this.commentaire = commentaire;
		this.clinic = clinic;
		this.patient = patient;
	}


	@EmbeddedId
	public ClinicBookingID getClinicBookingId() {
		return clinicBookingId;
	}


	public void setClinicBookingId(ClinicBookingID clinicBookingId) {
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
	
	


	@ManyToOne
	@JoinColumn(name = "clinicId", referencedColumnName = "clinicId", insertable = false, updatable = false)
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	


	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "userId", insertable = false, updatable = false)
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
