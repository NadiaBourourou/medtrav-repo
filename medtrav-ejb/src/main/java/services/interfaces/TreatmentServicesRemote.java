package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Procedure;
import entities.Treatment;

@Remote
public interface TreatmentServicesRemote {


	public Boolean assignProcedureToTreatment(Treatment newTreatment, Integer procedureId);

	boolean addTreatment(Treatment treatment); 
	
	boolean addProcedure(Procedure procedure);

//	Boolean assignTreatmentToProcedure(Treatment treatment, Integer procedureId);
	
	public List<Procedure> findAllProcedures();
	public List<Treatment> findAllTreatmentsByProcedureId(Integer procedureId);
	 String getTreatmentDescription(Integer treatmentId);
	
	
	
	
	
}
