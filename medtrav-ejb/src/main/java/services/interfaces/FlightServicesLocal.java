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
		
	List<Flight> findFlightsByAirline(String airline);
	
	Boolean assignFlightToBooking(Integer idBooking,Integer idFlight);
	Boolean assignFlightToBookingSlaveSide(Integer idBooking,Integer idFlight);
	
	Boolean assignDoctorToSurgery(Integer idSurgery,Integer idDoctor);
	Boolean assignDoctorToSurgerySlaveSide(Integer idSurgery,Integer idDoctor);
			
	Boolean assignMedicalRecordToSurgery(Integer idSurgery,Integer idMedicalRecord);
	Boolean assignMedicalRecordToSurgerySlaveSide(Integer idSurgery,Integer idMedicalRecord);



}
