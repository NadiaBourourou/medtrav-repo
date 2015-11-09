package tests.AssignedPatientsToDoc;

import java.util.List;

import delegates.AssigedPatientsServicesDelegate;
import entities.Doctor;
import entities.DoctorPatient;
import entities.Patient;

public class TestFindDoctorWithSpec {
	
	
public static void main(String[] args) {
		
		DoctorPatient doctor=AssigedPatientsServicesDelegate.doFindAssignPatient(1, 3);
		
		System.out.println("doc="+doctor);
		
}


}
