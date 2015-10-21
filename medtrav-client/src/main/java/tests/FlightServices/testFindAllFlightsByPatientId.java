package tests.FlightServices;

import java.util.List;

import delegates.FlightServicesDelegate;
import entities.Flight;

public class testFindAllFlightsByPatientId {
	
public static void main(String[] args) {
		
		List <Flight> flights=FlightServicesDelegate.doFindAllFlighstByPatient(1);
		
		System.out.println(flights.size()+" flights: \n");
		for(Flight f:flights)
		{System.out.println(f.getDepartureLocation()+"-"+f.getArrivalLocation());}
	}
	
}
