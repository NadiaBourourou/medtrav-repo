package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Doctor;
import entities.Patient;
import entities.Surgery;

@Local
public interface SurgeryServicesLocal {

	Surgery findSurgeryById(Integer idSurgery);

	List<Surgery> findAllSurgeriesByDoctorId(Integer idDoctor);

	List<Surgery> findAllSurgeriesByMedicalRecordsId(Integer idMedicalRecord);

	Boolean addSurgery(Surgery treatment);
	
	Boolean updateSurgery(Surgery treatment);

	Boolean deleteSurgery(Surgery treatment);
	
	List<Surgery> findAllSurgeries();
	
	Doctor findDoctorById(Integer idDoctor);

}
