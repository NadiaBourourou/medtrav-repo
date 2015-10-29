package entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: MedicalRecords
 *
 */
@Entity
@Table(name = "T_MEDICALRECORDS")
public class MedicalRecords implements Serializable {

	private Integer medicalRecordsId;
	private  byte[] analysis;
	private byte[] patientFile;
	private static final long serialVersionUID = 1L;

	private Patient patient;
	private List<Surgery> surgeries;

	public MedicalRecords() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMedicalRecordsId() {
		return this.medicalRecordsId;
	}

	public void setMedicalRecordsId(Integer MedicalRecordsId) {
		this.medicalRecordsId = MedicalRecordsId;
	}

	@Lob
	public byte[] getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis( byte[] analysis) {
		this.analysis = analysis;
	}

	@Lob
	public byte[] getPatientFile() {
		return this.patientFile;
	}

	public void setPatientFile(byte[] patientFile) {
		this.patientFile = patientFile;
	}

	@OneToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@OneToMany(mappedBy = "medicalRecords")
	public List<Surgery> getSurgeries() {
		return surgeries;
	}

	public void setSurgeries(List<Surgery> surgeries) {
		this.surgeries = surgeries;
	}

}
