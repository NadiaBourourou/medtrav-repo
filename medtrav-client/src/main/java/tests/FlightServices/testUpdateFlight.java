package tests.FlightServices;

import delegates.FlightServicesDelegate;
import entities.Flight;

public class testUpdateFlight {
	
	public static void main(String[] args) {
		
		Flight flight1 = new Flight();
		flight1.setArrivalLocation("Sfax");
		flight1.setDepartureLocation("Suisse");
		
		FlightServicesDelegate.doUpdateFlight(flight1);
	}
}
