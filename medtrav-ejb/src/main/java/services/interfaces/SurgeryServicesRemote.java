package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Doctor;
import entities.Flight;
import entities.Procedure;
import entities.Surgery;

@Remote
public interface SurgeryServicesRemote {
	Surgery findSurgeryById(Integer idSurgery);

	List<Surgery> findAllSurgeriesByDoctorId(Integer idDoctor);

	List<Surgery> findAllSurgeriesByMedicalRecordsId(Integer idMedicalRecord);

	public Boolean assignProcedureToSurgery(Surgery newTreatment,
			Integer procedureId);

	Boolean addSurgery(Surgery treatment);
	
	Boolean updateSurgery(Surgery treatment);

	Boolean deleteSurgery(Surgery treatment);
	
	List<Surgery> findAllSurgeries();

	void addSurgeryAndAssignItToProcedure(Surgery treatment, Integer idProcedure);

	boolean addProcedure(Procedure procedure);

	public List<Procedure> findAllProcedures();

	public List<Surgery> findAllSurgeriesByProcedureId(Integer procedureId);

	String getSurgeryDescription(Integer treatmentId);
	
	Doctor findDoctorById(Integer idDoctor);

	Boolean assignSurgeryToProcedureNv(Integer idSurgery, Integer idProcedure);
}
