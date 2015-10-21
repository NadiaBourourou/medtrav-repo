package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Flight;

@Local
public interface FlightServicesLocal {

	Boolean addFlight(Flight flight);

	Boolean updateFlight(Flight flight);

	Boolean deleteFlight(Flight flight);

	List<Flight> findAllFlightsByPatientId(Integer patientId);

	Flight findFlightById(Integer idFlight);

}
