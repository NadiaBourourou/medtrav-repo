package tests.FlightServices;

import delegates.FlightServicesDelegate;
import delegates.HotelServicesDelegate;
import entities.Flight;
import entities.Hotel;

public class testUpdateFlight {
	
	public static void main(String[] args) {
		
		//Flight flight1 = new Flight();
		Flight flight1=FlightServicesDelegate.doFindFlightById(1);
		
		flight1.setArrivalLocation("Sfax");
		flight1.setDepartureLocation("Suisse");
		
		FlightServicesDelegate.doUpdateFlight(flight1);
	}
}
