package tests.UserServices;

import java.util.List;

import delegates.UserServicesDelegate;
import entities.Doctor;

public class TestFindDoctorsBySpecialty {

	public static void main(String[] args) {
		List<Doctor> doctors=UserServicesDelegate.doFindDoctorsBySpecialty("neuro");
	//	List<Doctor> doctors=UserServicesDelegate.doFindAllDoctors();
for (Doctor d : doctors) {
	System.out.println(d.getCin().toString());
	
}
	}

}
