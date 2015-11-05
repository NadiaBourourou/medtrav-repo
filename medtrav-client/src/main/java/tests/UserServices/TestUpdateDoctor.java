package tests.UserServices;

import delegates.UserServicesDelegate;
import entities.Doctor;

public class TestUpdateDoctor {

	public static void main(String[] args) {
	Doctor foundDoc=UserServicesDelegate.doFindDoctorById(2);
	foundDoc.setCin("14751650");
	UserServicesDelegate.doUpdateDoctor(foundDoc);
	

	}

}
