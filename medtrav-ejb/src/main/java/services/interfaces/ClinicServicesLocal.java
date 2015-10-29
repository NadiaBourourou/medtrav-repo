package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Clinic;

@Local
public interface ClinicServicesLocal {

	Boolean addClinic(Clinic clinic);

	Boolean deleteClinicById(Integer id);

	Clinic findClinicById(Integer id);

	Boolean updateClinic(Clinic clinic);

	Boolean deleteClinic(Clinic clinic);

	List<Clinic> findAllClinics();
}
