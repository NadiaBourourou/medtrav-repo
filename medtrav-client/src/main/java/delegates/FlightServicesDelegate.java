package delegates;

import java.util.Date;
import java.util.List;

import entities.Flight;
import entities.FlightMatching;
import entities.Patient;
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

	public static List<FlightMatching> doFindFlightsByAirline(String airline) {
		return getProxy().findFlightsByAirline(airline);
	}

	public static Boolean doAssignFlightToBooking(Integer idBooking,
			Integer idFlight) {
		return getProxy().assignFlightToBooking(idBooking, idFlight);
	}

	public static Boolean doAssignFlightToBookingSlaveSide(Integer idBooking,
			Integer idFlight) {
		return getProxy().assignFlightToBookingSlaveSide(idBooking, idFlight);
	}

	public static Boolean doAssignDoctorToSurgery(Integer idSurgery,
			Integer idDoctor) {
		return getProxy().assignDoctorToSurgery(idSurgery, idDoctor);

	}

	public static Boolean doAssignDoctorToSurgerySlaveSide(Integer idSurgery,
			Integer idDoctor) {
		return getProxy().assignDoctorToSurgerySlaveSide(idSurgery, idDoctor);
	}
/*
	public static Boolean doAssignMedicalRecordToSurgery(Integer idSurgery,
			Integer idMedicalRecord) {
		return getProxy().assignMedicalRecordToSurgery(idSurgery,
				idMedicalRecord);
	}

	public static Boolean doAssignMedicalRecordToSurgerySlaveSide(
			Integer idSurgery, Integer idMedicalRecord) {
		return getProxy().assignMedicalRecordToSurgerySlaveSide(idSurgery,
				idMedicalRecord);
	}
*/
	public static List<FlightMatching> doFindAllDepartures() {
		return getProxy().findAllDepartures();
	}

	public static List<FlightMatching> doFindAllArrivals() {
		return getProxy().findAllArrivals();

	}

	public static List<FlightMatching> doFindMatchingFlight(String departure,
			String arrival, String dateDeparture, String dateArrival) {
		return getProxy().findMatchingFlight(departure, arrival, dateDeparture,
				dateArrival);
	}

	public static List<Flight> doFindAllFlight() {
		return getProxy().findAllFlight();
	}

	public static Patient doFindPatientById(Integer idPatient) {
		return getProxy().findPatientById(idPatient);
	}

	public static FlightMatching doFindFlightMatchingById(Integer idFmatching)
	{
		return getProxy().findFlightMatchingById(idFmatching);
	}
	
	public static Boolean doUpdateNbSits(Integer nbSitsMaj,Integer idFlight){
		return getProxy().updateNbSits(nbSitsMaj,idFlight);
	}
}
