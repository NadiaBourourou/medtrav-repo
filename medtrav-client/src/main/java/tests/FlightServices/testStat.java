package tests.FlightServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import delegates.FlightServicesDelegate;
import entities.Flight;
import entities.FlightMatching;

//public List<String> findAllDepaturesSansDoublons() 
//public List<String> findAllDepaturesOfOurPatients() 

//System.out.println(a.get(i));

public class testStat {
	public static void main(String[] args) {

		List<String> ourAirlines=FlightServicesDelegate.doFindAllAirlines();
		
		for(int i=0;i<ourAirlines.size();i++)
		{
		
		//System.out.println(ourAirlines.get(i));
		long a= FlightServicesDelegate.doMostWorkingAirlines(ourAirlines.get(i));
		System.out.println(ourAirlines.get(i)+" "+a);
		}
	}
}


