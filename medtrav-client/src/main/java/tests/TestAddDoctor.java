package tests;

import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.RoleType;

public class TestAddDoctor {

	public static void main(String[] args) {
		Doctor doc = new Doctor();
		doc.setUserId(2);
		doc.setCin(140);
	
		doc.setFirstName("Nadia");
		doc.setLastName("Boo");
		doc.setLogin("fwl");
		doc.setPassword("pwd");
		doc.setMail("flen@gmail.tn");
		doc.setSpecialty("neuro");
		doc.setDescription("description");		
		
		UserServicesDelegate.doaAddDocor(doc);
		
	}

}
