package tests.TestimonyServices;

import delegates.TestimonyServicesDelegate;
import entities.Testimony;

public class TestUpdateTestimony {

	
	
	public static void main(String[] args) {
		
		//Testimony testimonyFound=TestimonyServicesDelegate.doFindTestimonyById(1);
		Testimony testimony1 = new Testimony();
		testimony1.setTitle("Third travel");
		testimony1.setDescription("My third testimony");
		
		TestimonyServicesDelegate.doUpdateTestimony(testimony1);
	}
	
}
