package tests.TestimonyServices;

import delegates.TestimonyServicesDelegate;
import entities.Testimony;



public class TestDeleteTestimony {
	
	public static void main(String[] args) {
		
		Testimony testimonyFound=TestimonyServicesDelegate.doFindTestimonyById(4);
		TestimonyServicesDelegate.doDeleteTestimony(testimonyFound);
	}

}
