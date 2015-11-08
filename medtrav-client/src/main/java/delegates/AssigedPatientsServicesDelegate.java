package delegates;

import java.util.List;

import entities.Doctor;
import entities.Patient;
import entities.DoctorPatient;
import locator.ServiceLocator;
import services.interfaces.AssignedPatientsServicesRemote;

public class AssigedPatientsServicesDelegate {



	public static final String jndiName = "/medtrav-ejb/AssignedPatientsServices!services.interfaces.AssignedPatientsServicesRemote";

	public static AssignedPatientsServicesRemote getProxy() {
		return (AssignedPatientsServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}


	public static List<Patient> doFindAllPatientsByDoctorId(Integer doctorId) {
		return getProxy().findAllPatientsByDoctorId(doctorId);
	}
	
	public static Boolean doAssignPatientToDoctor(Doctor doctor,
			Integer idPatient) {
		return getProxy().assignPatientToDoctor(doctor, idPatient);
	}
	
	public static Boolean doAssignPatientToDoctorId(Integer doctorId,
			Integer idPatient) {
		return getProxy().assignPatientToDoctorId(doctorId, idPatient);
	}
	
	public static Boolean doAcceptPatient(Patient patient) {
		return getProxy().acceptPatient(patient);
	}
	
	public static Boolean doDeleteAssignPatient(Integer patientId,Integer doctorId) {
		return getProxy().deleteAssignPatient(patientId, doctorId);
	}
	
	public static Boolean doRefusePatient(Patient patient,Integer doctorId) {
		return getProxy().refusePatient(patient,doctorId);
	}
	
	
	public static DoctorPatient doFindAssignPatient(Integer patientId,Integer doctorId)  {
		return getProxy().findAssignPatient(patientId, doctorId);
	}
	
	

	public static Doctor doFindDoctorsBySpecAndNotThisDoc(String specialite,Integer doctorId) {
		return getProxy().findDoctorsBySpecialtyAndNotThisDoc(specialite, doctorId);
	}
	
	
}
