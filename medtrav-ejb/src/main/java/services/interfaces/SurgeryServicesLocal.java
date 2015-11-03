package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Surgery;

@Local
public interface SurgeryServicesLocal {

	Surgery findSurgeryById(Integer idSurgery);

	List<Surgery> findAllSurgeriesByDoctorId(Integer idDoctor);

	List<Surgery> findAllSurgeriesByMedicalRecordsId(Integer idMedicalRecord);

}
