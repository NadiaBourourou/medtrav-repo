package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DoctorPatient
 *
 */
@Entity

public class DoctorPatient implements Serializable {
	
	private DoctorPatientID id;
	
	private static final long serialVersionUID = 1L;

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
	
	
	
	
   
}
