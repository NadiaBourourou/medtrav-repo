package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Intervention
 *
 */
@Entity
@Table(name = "t_procedure")
public class Procedure implements Serializable {

	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;

	private List<Surgery> treatments;

	public Procedure() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy = "procedure")
	public List<Surgery> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Surgery> treatments) {
		this.treatments = treatments;
	}

}
