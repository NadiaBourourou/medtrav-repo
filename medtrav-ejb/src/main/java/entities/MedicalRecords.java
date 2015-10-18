package entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private Blob analysis;
	private String patientFile;
	private static final long serialVersionUID = 1L;

	private Patient patient;
	private List<Surgery> surgeries;

	public MedicalRecords() {
		super();
	}

	@Id
	public Integer getMedicalRecordsId() {
		return this.medicalRecordsId;
	}

	public void setMedicalRecordsId(Integer MedicalRecordsId) {
		this.medicalRecordsId = MedicalRecordsId;
	}

	public Blob getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(Blob analysis) {
		this.analysis = analysis;
	}

	public String getPatientFile() {
		return this.patientFile;
	}

	public void setPatientFile(String patientFile) {
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
