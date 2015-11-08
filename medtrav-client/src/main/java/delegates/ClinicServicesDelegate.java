package delegates;

import java.util.List;
import java.util.Date;

import locator.ServiceLocator;
import services.interfaces.ClinicServicesRemote;
import entities.Clinic;
import entities.ClinicBooking;
import entities.RoomClinicType;

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
	public static boolean doDeleteClinic(Clinic Clinic) {
		return getProxy().deleteClinic(Clinic);
	}

	public static Clinic doFindClinicById(Integer id) {
		return getProxy().findClinicById(id);
	}

	public static List<Clinic> doFindAllClinics() {
		return getProxy().findAllClinics();
	}
	
	public static List<Clinic> doFindClinicByName(String name){
		return getProxy().findClinicByName(name);
	}

	public static boolean doAddClinicBookingAndAffectClinic (ClinicBooking hb,Integer id){
		return getProxy().addClinicBookingAndAffectClinic(hb, id);
	}
	
	public static Boolean doBookClinic(RoomClinicType typeRoom, Date date,
			String commentaire, Clinic clinic, Integer idPatient) {
		return getProxy().bookClinic(typeRoom, date, commentaire, clinic, idPatient);
	}
}
