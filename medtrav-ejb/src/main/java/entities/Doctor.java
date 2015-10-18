package entities;

import entities.User;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Doctor
 *
 */
@Entity
@Table(name="T_DOCTOR")
public class Doctor extends User implements Serializable {

	
	private String specialty;
	private String description;
	private static final long serialVersionUID = 1L;

	public Doctor() {
		super();
	}   
	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
