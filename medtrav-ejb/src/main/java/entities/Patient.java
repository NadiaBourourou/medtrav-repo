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
	private PatientState state;

	private List<Testimony> testimonies;
	private MedicalRecords medicalRecords;
	private HotelBooking hotelBooking;
	private ClinicBooking clinicBooking;
	private Flight flight;
	private List<SurgeryPatient> surgeryPatients;

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

	public PatientState getState() {
		return state;
	}

	public void setState(PatientState state) {
		this.state = state;
	}

	@OneToOne(mappedBy = "patient")
	public HotelBooking getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(HotelBooking hotelBooking) {
		this.hotelBooking = hotelBooking;
	}

	@OneToOne(mappedBy = "patient")
	public ClinicBooking getClinicBooking() {
		return clinicBooking;
	}

	public void setClinicBooking(ClinicBooking clinicBooking) {
		this.clinicBooking = clinicBooking;
	}

	@OneToOne(mappedBy = "patient")
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@OneToMany(mappedBy = "patient")
	public List<SurgeryPatient> getSurgeryPatients() {
		return surgeryPatients;
	}

	public void setSurgeryPatients(List<SurgeryPatient> surgeryPatients) {
		this.surgeryPatients = surgeryPatients;
	}

}
