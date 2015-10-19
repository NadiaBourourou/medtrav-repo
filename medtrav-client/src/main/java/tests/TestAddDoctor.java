package tests;

import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.RoleType;

public class TestAddDoctor {

	public static void main(String[] args) {
		Doctor doc = new Doctor();
		doc.setUserId(1);
		doc.setCin(14);
	
		doc.setFirstName("Flen");
		doc.setLastName("Weld Falten");
		doc.setLogin("fwl");
		doc.setPassword("pwd");
		doc.setMail("flen@gmail.tn");
		doc.setSpecialty("Chirurgie");
		doc.setDescription("ceci est ma description");		
		
		UserServicesDelegate.doaAddDocor(doc);
		
	}

}
