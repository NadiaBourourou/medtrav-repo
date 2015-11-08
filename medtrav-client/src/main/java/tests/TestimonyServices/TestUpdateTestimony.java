package tests.TestimonyServices;

import delegates.TestimonyServicesDelegate;
import entities.Testimony;

public class TestUpdateTestimony {

	
	
	public static void main(String[] args) {
		
		Testimony testimonyFound=TestimonyServicesDelegate.doFindTestimonyById(5);
		//Testimony testimony1 = new Testimony();
		//testimony1.setTitle("Third travel");
		testimonyFound.setDescription("coucou");
		
		TestimonyServicesDelegate.doUpdateTestimony(testimonyFound);
	}
	
}
