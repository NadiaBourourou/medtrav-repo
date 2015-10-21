package tests.TestimonyServices;

import java.util.List;

import delegates.TestimonyServicesDelegate;
import entities.Testimony;

public class TestFindAllTestimoniesByPatientId {

public static void main(String[] args) {
		
		List <Testimony> testimonies=TestimonyServicesDelegate.doFindAllTestimoniesByPatient(1);
		
		System.out.println("We have "+testimonies.size()+" testimonies: \n");
		for(Testimony t:testimonies)
		{System.out.println(t.getTitle());}
	}
	
}
