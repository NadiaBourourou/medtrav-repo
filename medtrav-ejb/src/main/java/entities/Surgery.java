package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Surgery
 *
 */
@Entity
public class Surgery implements Serializable {

	private String name;
	private SurgeryId surgeryId;

	private Doctor doctor;
	private MedicalRecords medicalRecords;

	private static final long serialVersionUID = 1L;

	public Surgery() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@EmbeddedId
	public SurgeryId getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(SurgeryId surgeryId) {
		this.surgeryId = surgeryId;
	}

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", updatable = false, insertable = false)
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@ManyToOne
	@JoinColumn(name = "medicalRecordsId", referencedColumnName = "id", updatable = false, insertable = false)
	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
