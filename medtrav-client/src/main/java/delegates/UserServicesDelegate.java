package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.UserServicesRemote;
import entities.Doctor;

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

	public static boolean doRemoveDoctor(Doctor doctor) {
		return getProxy().removeDoctor(doctor);
	}

	public static Doctor doFindDoctorById(Integer id) {
		return getProxy().findDoctorById(id);
	}

	public static List<Doctor> doFindDoctorsBySpecialty(String specialty) {
		return getProxy().findDoctorsBySpecialty(specialty);
	}

}
