package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity
public class Patient extends User implements Serializable {

	private Date dateOfBirth;
	private String country;
	private Integer numPassport;

	private List<Booking> bookings;
	private List<Testimony> testimonies;
	private MedicalRecords medicalRecords;

	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getNumPassport() {
		return this.numPassport;
	}

	public void setNumPassport(Integer numPassport) {
		this.numPassport = numPassport;
	}

	@OneToMany(mappedBy = "patient")
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@OneToMany(mappedBy = "patient")
	public List<Testimony> getTestimonies() {
		return testimonies;
	}

	public void setTestimonies(List<Testimony> testimonies) {
		this.testimonies = testimonies;
	}

	@OneToOne(mappedBy = "patient")
	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
