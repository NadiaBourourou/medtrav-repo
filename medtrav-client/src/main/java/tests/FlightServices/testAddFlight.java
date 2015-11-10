package tests.FlightServices;

import java.util.Date;

import delegates.FlightServicesDelegate;
import entities.Flight;

public class testAddFlight {
	
	public static void main(String[] args) {
		
		Flight flight1 = new Flight();
		flight1.setArrivalDate(new Date());
		flight1.setArrivalLocation("Tunis");
		flight1.setDepartureDate(new Date());
		flight1.setDepartureLocation("Paris");
		flight1.setPrice(500D);
		FlightServicesDelegate.doAddFlight(flight1);
		
		Flight flight2 = new Flight();
		flight2.setArrivalDate(new Date());
		flight2.setArrivalLocation("Tunis");
		flight2.setDepartureDate(new Date());
		flight2.setDepartureLocation("Barcelone");
		flight2.setPrice(900D);
		FlightServicesDelegate.doAddFlight(flight2);

		Flight flight3 = new Flight();
		flight3.setArrivalDate(new Date());
		flight3.setArrivalLocation("Tunis");
		flight3.setDepartureDate(new Date());
		flight3.setDepartureLocation("Abidjan");
		flight3.setPrice(150D);
		FlightServicesDelegate.doAddFlight(flight3);

	}
}
