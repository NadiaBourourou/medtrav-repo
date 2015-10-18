package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Testimony
 *
 */
@Entity
@Table(name = "T_TESTIMONY")
public class Testimony implements Serializable {
	
	private Integer testimonyId;
	private String description;

	private Patient patient;

	private static final long serialVersionUID = 1L;

	public Testimony() {
		super();
	}

	@Id
	public Integer getTestimonyId() {
		return this.testimonyId;
	}

	public void setTestimonyId(Integer testimonyId) {
		this.testimonyId = testimonyId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
