package tests.FlightServices;

import java.util.List;

import delegates.FlightServicesDelegate;
import entities.Flight;

public class TestFindFlightsByAirline {

	public static void main(String[] args) {
		List<Flight> flights = FlightServicesDelegate.doFindFlightsByAirline("Tunisair");
		for (Flight f : flights) {
			System.out.println("From : "+" "+f.getDepartureLocation()+" "+"To : "+f.getArrivalLocation());

		}
	}

}
