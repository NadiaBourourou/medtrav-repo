package delegates;

import locator.ServiceLocator;
import services.interfaces.ClinicBookingServicesRemote;
import services.interfaces.ClinicServicesRemote;
import entities.Clinic;
import entities.ClinicBooking;
import entities.RoomClinicType;

public class ClinicBookingServicesDelegate {
	private ClinicServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/ClinicBookingServices!services.interfaces.ClinicBookingServicesRemote";

	private static ClinicBookingServicesRemote getProxy() {
		return (ClinicBookingServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	

	public static boolean doAddClinicBookingAndAffectClinic (ClinicBooking hb,Integer id){
		return getProxy().addClinicBookingAndAffectClinic(hb, id);
	}
	
	public static Boolean doBookClinic(RoomClinicType typeRoom, String date,
			String commentaire, Clinic clinic, Integer idPatient) {
		return getProxy().bookClinic(typeRoom, date, commentaire, clinic, idPatient);
	}
}
