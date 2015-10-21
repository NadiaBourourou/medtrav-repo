package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Flight;

@Remote
public interface FlightServicesRemote {
	
	Boolean addFlight(Flight flight);

	Boolean updateFlight(Flight flight);

	Boolean deleteFlight(Flight flight);

	List<Flight> findAllFlightsByPatientId(Integer patientId);

	Flight findFlightById(Integer idFlight);
}
