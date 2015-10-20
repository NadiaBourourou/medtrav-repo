package tests.TestimonyServices;

import delegates.TestimonyServicesDelegate;
import entities.Testimony;


public class TestAddTestimony {

	public static void main(String[] args) {
		
		Testimony testimony1 = new Testimony();
		testimony1.setTitle("First travel");
		testimony1.setDescription("My first testimony");

		TestimonyServicesDelegate.doAddTestimony(testimony1);
		
		Testimony testimony2 = new Testimony();
		testimony2.setTitle("Second travel");
		testimony2.setDescription("My second testimony");

		TestimonyServicesDelegate.doAddTestimony(testimony2);

	}
	
}
