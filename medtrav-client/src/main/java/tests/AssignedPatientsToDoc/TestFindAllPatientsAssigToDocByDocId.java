package tests.AssignedPatientsToDoc;

import java.util.List;

import delegates.AssigedPatientsServicesDelegate;
import delegates.TestimonyServicesDelegate;
import entities.Patient;
import entities.Testimony;

public class TestFindAllPatientsAssigToDocByDocId {

	
public static void main(String[] args) {
		
		List <Patient> patients=AssigedPatientsServicesDelegate.doFindAllPatientsByDoctorId(3);
		
		System.out.println("We have "+patients.size()+" patient: \n");
		for(Patient t:patients)
		{System.out.println(t.getFirstName());}
	}
	
	
}
