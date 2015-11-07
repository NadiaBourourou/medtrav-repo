package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: DoctorPatient
 *
 */
@Entity
public class DoctorPatient implements Serializable {

	private DoctorPatientID id;

	private static final long serialVersionUID = 1L;

	private List<Booking> bookings;
	private Doctor doctor;
	private Patient patient;

	public DoctorPatient() {
		super();
	}

	@EmbeddedId
	public DoctorPatientID getId() {
		return id;
	}

	public void setId(DoctorPatientID id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "doctorPatient")
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@ManyToOne
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
