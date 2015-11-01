package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Surgery;

@Remote
public interface SurgeryServicesRemote {
	Surgery findSurgeryById(Integer idSurgery);

	List<Surgery> findAllSurgeriesByDoctorId(Integer idDoctor);

	List<Surgery> findAllSurgeriesByMedicalRecordsId(Integer idMedicalRecord);

}
