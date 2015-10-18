package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Blob;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MedicalRecords
 *
 */
@Entity
@Table(name="T_MEDICALRECORDS")
public class MedicalRecords implements Serializable {

	
	private Integer MedicalRecordsId;
	private String surgery;
	private Blob analysis;
	private String patientFile;
	private static final long serialVersionUID = 1L;

	public MedicalRecords() {
		super();
	}   
	@Id    
	public Integer getMedicalRecordsId() {
		return this.MedicalRecordsId;
	}

	public void setMedicalRecordsId(Integer MedicalRecordsId) {
		this.MedicalRecordsId = MedicalRecordsId;
	}   
	public String getSurgery() {
		return this.surgery;
	}

	public void setSurgery(String surgery) {
		this.surgery = surgery;
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
   
}
