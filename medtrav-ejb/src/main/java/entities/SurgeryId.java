package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SurgeryId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer medicalRecordsId;
	private Integer doctorId;
	
	public SurgeryId() {
		super();
	}

	public SurgeryId(Integer medicalRecordsId, Integer doctorId) {
		super();
		this.medicalRecordsId = medicalRecordsId;
		this.doctorId = doctorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((doctorId == null) ? 0 : doctorId.hashCode());
		result = prime
				* result
				+ ((medicalRecordsId == null) ? 0 : medicalRecordsId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurgeryId other = (SurgeryId) obj;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
			return false;
		if (medicalRecordsId == null) {
			if (other.medicalRecordsId != null)
				return false;
		} else if (!medicalRecordsId.equals(other.medicalRecordsId))
			return false;
		return true;
	}

	public Integer getMedicalRecordsId() {
		return medicalRecordsId;
	}

	public void setMedicalRecordsId(Integer medicalRecordsId) {
		this.medicalRecordsId = medicalRecordsId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	
	
	
}
