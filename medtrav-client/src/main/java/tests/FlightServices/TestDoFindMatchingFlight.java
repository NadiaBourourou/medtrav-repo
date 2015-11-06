package tests.FlightServices;

import java.util.Date;
import java.util.List;

import delegates.FlightServicesDelegate;
import entities.Flight;
import entities.FlightMatching;

public class TestDoFindMatchingFlight {

	public static void main(String[] args) {
		
		
		List <FlightMatching> flights=FlightServicesDelegate.doFindMatchingFlight("Lyon - Lyon-Saint-Exupéry (LYS)", "Djerba - Djerba–Zarzis International Airport (DJE)", "","");
		
		System.out.println(flights.size()+" flights: \n");
		for(FlightMatching f:flights)
		{System.out.println(f.getDeparture()+" - "+f.getArrival()+" - "+f.getAirline()+" - "+f.getDateFlightMatchingDep()+" - "+f.getDateFlightMatchingArr());}

	}

}
