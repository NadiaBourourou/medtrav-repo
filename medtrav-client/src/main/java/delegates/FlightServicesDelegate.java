package delegates;

import java.util.List;

import entities.Flight;
import locator.ServiceLocator;
import services.interfaces.FlightServicesRemote;

public class FlightServicesDelegate {
	public static final String jndiName = "/medtrav-ejb/FlightServices!services.interfaces.FlightServicesRemote";

	public static FlightServicesRemote getProxy() {
		return (FlightServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doAddFlight(Flight flight) {
		getProxy().addFlight(flight);
	}

	public static void doUpdateFlight(Flight flight) {
		getProxy().updateFlight(flight);
	}

	public static Flight doFindFlightById(Integer idFlight) {
		return getProxy().findFlightById(idFlight);
	}

	public static void doDeleteFlight(Flight flight) {
		getProxy().deleteFlight(flight);
	}

	public static List<Flight> doFindAllFlighstByPatient(Integer patientId) {
		return getProxy().findAllFlightsByPatientId(patientId);
	}
}
