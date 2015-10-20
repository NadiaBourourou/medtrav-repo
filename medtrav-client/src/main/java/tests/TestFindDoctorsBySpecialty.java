package tests;

import java.util.List;

import delegates.UserServicesDelegate;
import entities.Doctor;

public class TestFindDoctorsBySpecialty {

	public static void main(String[] args) {
		List<Doctor> doctors=UserServicesDelegate.doFindDoctorsBySpecialty("neuro");
for (Doctor d : doctors) {
	System.out.println(d.getCin().toString());
	
}
	}

}
