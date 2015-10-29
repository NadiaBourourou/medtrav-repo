package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Doctor;
import entities.Patient;
import entities.User;

@Remote
public interface UserServicesRemote {

	boolean addDocor(Doctor doctor);
	boolean updateDoctor(Doctor doctor);
	boolean removeDoctor(Integer doctorId);
	Doctor findDoctorById(Integer id);
	List <Doctor> findDoctorsBySpecialty(String specialty);
	
	
	
	boolean addPatient(Patient patient);
	boolean updatePatient(Patient patient);
	boolean removePatient(Integer patientId);
	Patient findPatientByPassportNumber (Integer nbPassport);
	List<Patient> findAlltreatedPatiends();
	List<Patient> listAllPatients() ;
	
	User userIdentification(String login, String password);
	
	
	
}
