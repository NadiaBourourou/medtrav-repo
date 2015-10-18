package entities;

import entities.User;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity

public class Patient extends User implements Serializable {

	
	private Date dateOfBirth;
	private String country;
	private Integer numPassport;
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
   
}
