package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Procedure;
import entities.Treatment;

@Remote
public interface TreatmentServicesRemote {

	public Boolean assignProcedureToTreatment(Treatment newTreatment,
			Integer procedureId);

	boolean addTreatment(Treatment treatment);

	void addTreatmentAndAssignItToProcedure(Treatment treatment, Integer idProcedure);

	boolean addProcedure(Procedure procedure);

	public List<Procedure> findAllProcedures();

	public List<Treatment> findAllTreatmentsByProcedureId(Integer procedureId);

	String getTreatmentDescription(Integer treatmentId);

}
