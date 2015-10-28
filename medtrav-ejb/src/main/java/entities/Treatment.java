package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

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
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "procedureId", referencedColumnName = "id", updatable = false, insertable = false)
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	
	
   
}
