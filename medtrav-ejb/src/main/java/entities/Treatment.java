package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Treatment
 *
 */
@Entity
@Table(name="t_treatment")
public class Treatment implements Serializable {

	
	private Integer id;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;

	private Procedure procedure;
	
	public Treatment() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	
	
   
}
