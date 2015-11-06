package tests.FlightServices;

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

		int count[] = { 0,0,0,0};
		
		List<String> a = FlightServicesDelegate
				.doFindAllDepaturesSansDoublons();
		List<String> b = FlightServicesDelegate
				.doFindAllDepaturesOfOurPatients();

		for (int i = 0; i < a.size(); i++) {

			for (int j = 0; j < b.size(); i++) {
				if(a.get(i).equals(b.get(j))){
					count[i]=0;
					count[i]=count[i]+1;
					System.out.println("Depature = "+a.get(i)+" "+"count = "+ count[i]);
				}

			}
		}

	}

}
