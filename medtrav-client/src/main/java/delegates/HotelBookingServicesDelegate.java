package delegates;

import locator.ServiceLocator;
import services.interfaces.HotelBookingServicesRemote;
import services.interfaces.HotelServicesRemote;
import entities.Hotel;
import entities.HotelBooking;

public class HotelBookingServicesDelegate {
	private HotelServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/HotelBookingServices!services.interfaces.HotelBookingServicesRemote";

	private static HotelBookingServicesRemote getProxy() {
		return (HotelBookingServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Double doCalculPrix(Double prix, Double numNights) {
		return getProxy().calculPrix(prix, numNights);
	}

	public static boolean doAddHotelBooking (HotelBooking hb){
		return getProxy().addHotelBooking(hb);
	}
	

	
}
