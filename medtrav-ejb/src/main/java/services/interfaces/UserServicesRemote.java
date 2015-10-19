package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Doctor;

@Remote
public interface UserServicesRemote {

	boolean addDocor(Doctor doctor);
	boolean updateDoctor(Doctor doctor);
	boolean removeDoctor(Integer doctorId);
	Doctor findDoctorById(Integer id);
	List <Doctor> findDoctorsBySpecialty(String specialty);
	
	
	
}
