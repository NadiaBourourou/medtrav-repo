package tests.FlightServices;

import java.util.List;

import delegates.FlightServicesDelegate;
import entities.Flight;
import entities.FlightMatching;

public class TestFindFlightsByAirline {

	public static void main(String[] args) {
		List<FlightMatching> flights = FlightServicesDelegate.doFindFlightsByAirline("TUNISAIR");
		for (FlightMatching f : flights) {
			System.out.println("From : "+" "+f.getDeparture()+" "+"To : "+f.getArrival());

		}
	}

}
