package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Testimony
 *
 */
@Entity

public class Testimony implements Serializable {

	   
	@Id
	private Integer testimonyId;
	private String description;
	private static final long serialVersionUID = 1L;

	public Testimony() {
		super();
	}   
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
   
}
