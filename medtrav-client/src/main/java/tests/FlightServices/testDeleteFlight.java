package tests.FlightServices;

import delegates.FlightServicesDelegate;
import entities.Flight;

public class testDeleteFlight {
	
	public static void main(String[] args) {
		
		Flight flightFound=FlightServicesDelegate.doFindFlightById(4);
		FlightServicesDelegate.doDeleteFlight(flightFound);
	}

}
