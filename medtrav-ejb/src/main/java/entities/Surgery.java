package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Surgery
 *
 */
@Entity

public class Surgery implements Serializable {

	
	private String name;
	private SurgeryId surgeryId;
	
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
   
}
