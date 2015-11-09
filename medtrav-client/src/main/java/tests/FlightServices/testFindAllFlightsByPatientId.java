package tests.FlightServices;

import java.util.List;

import delegates.FlightServicesDelegate;
import delegates.SurgeryServicesDelegate;
import entities.Flight;

public class testFindAllFlightsByPatientId {
	
public static void main(String[] args) {
		
		List <Flight> flights=FlightServicesDelegate.doFindAllFlighstByPatient(2);
		
		System.out.println("We have "+flights.size()+" flights: \n");
		for(Flight f:flights)
		{System.out.println(f.getDepartureLocation()+"-"+f.getArrivalLocation());}
	}
	
	
	
	
/*	int taille=FlightServicesDelegate.doFindAllFlighstByPatient(2).size();
for (int i=0;i<taille;i++)
{
System.out.println(FlightServicesDelegate.doFindAllFlighstByPatient(2).get(i));	

}*/
}
	


