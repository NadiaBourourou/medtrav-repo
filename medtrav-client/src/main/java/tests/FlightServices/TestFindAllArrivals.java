package tests.FlightServices;

import java.util.Iterator;
import java.util.List;

import delegates.FlightServicesDelegate;

public class TestFindAllArrivals {

	public static void main(String[] args) {
		List<String> arrivals = FlightServicesDelegate.doFindAllArrivals();

		System.out.println(arrivals.size() + " departures: \n");

		Iterator i = arrivals.iterator();
		while(i.hasNext()){
		 String x = (String) i.next(); //La méthode next() renvoie un objet de type Object.Il faut donc caster le résultat avec le type correspondant.
		System.out.println("x");
		}
	}

}
