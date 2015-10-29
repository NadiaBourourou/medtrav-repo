package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.ClinicServicesRemote;
import entities.Clinic;

public class ClinicServicesDelegate {
	private ClinicServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/ClinicServices!services.interfaces.ClinicServicesRemote";

	private static ClinicServicesRemote getProxy() {
		return (ClinicServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddClinic(Clinic Clinic) {
		return getProxy().addClinic(Clinic);
	}

	public static boolean doUpdateClinic(Clinic Clinic) {
		return getProxy().updateClinic(Clinic);
	}

	public static boolean doDeleteClinicById(Integer ClinicId) {
		return getProxy().deleteClinicById(ClinicId);
	}
	public static boolean doDeleteClinicById(Clinic Clinic) {
		return getProxy().deleteClinic(Clinic);
	}

	public static Clinic doFindClinicById(Integer id) {
		return getProxy().findClinicById(id);
	}

	public static List<Clinic> doFindAllClinics() {
		return getProxy().findAllClinics();
	}
}
