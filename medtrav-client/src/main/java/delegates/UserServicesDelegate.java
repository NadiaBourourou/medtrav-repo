package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.UserServicesRemote;
import entities.Doctor;
import entities.Patient;

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

}
