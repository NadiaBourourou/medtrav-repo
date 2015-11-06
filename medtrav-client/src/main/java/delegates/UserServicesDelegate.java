package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.UserServicesRemote;
import entities.Administrator;
import entities.Doctor;
import entities.Patient;
import entities.User;

public class UserServicesDelegate {

	private UserServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/UserServices!services.interfaces.UserServicesRemote";

	private static UserServicesRemote getProxy() {
		return (UserServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doaAddDocor(Doctor doctor) {
		return getProxy().addDocor(doctor);
	}

	public static boolean doUpdateDoctor(Doctor doctor) {
		return getProxy().updateDoctor(doctor);
	}

	public static boolean doRemoveDoctor(Integer doctorId) {
		return getProxy().removeDoctor(doctorId);
	}

	public static Doctor doFindDoctorById(Integer id) {
		return getProxy().findDoctorById(id);
	}

	public static List<Doctor> doFindDoctorsBySpecialty(String specialty) {
		return getProxy().findDoctorsBySpecialty(specialty);
	}

	public static List<Doctor> doFindAllDoctors() {
		return getProxy().findAllDoctors();
	}

	// _____________________________________________
	// ____________PATIENT _________________________
	// _____________________________________________

	public static boolean doAddPatient(Patient patient) {
		return getProxy().addPatient(patient);
	}

	public static boolean doUpdatePatient(Patient patient) {
		return getProxy().updatePatient(patient);
	}

	public static boolean doRemovePatient(Integer patientId) {
		return getProxy().removePatient(patientId);
	}

	public static Patient doFindPatientByPassportNumber(Integer nbPassport) {
		return getProxy().findPatientByPassportNumber(nbPassport);
	}

	public static List<Patient> doListAllPatient() {
		return getProxy().listAllPatients();
	}

	public static Patient dofindPatientByFirstAndLastName(String firstName,
			String lastName) {
		return getProxy().findPatientByFirstAndLastName(firstName, lastName);
	}
	public static Patient doFindPatientById(Integer id) {
		return getProxy().findPatientById(id);
	}

	// _____________________________________________
	// ____________Admin _________________________
	// _____________________________________________

	public static boolean doAddAdmin(Administrator admin) {
		return getProxy().addAdmin(admin);
	}

	// _____________________________________________
	// ____________COMMON _________________________
	// _____________________________________________

	public static User doUserIdentification(String login, String password) {
		return getProxy().userIdentification(login, password);
	}
}
