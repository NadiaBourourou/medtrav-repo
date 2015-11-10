package tests.AssignedPatientsToDoc;

import delegates.AssigedPatientsServicesDelegate;
import delegates.SurgeryServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Surgery;

public class TestAssignPatientToDoctor {
	public static void main(String[] args){
		
		
System.out.println(AssigedPatientsServicesDelegate.doAssignPatientToDoctorId(3,1));
//	Surgery surgery=SurgeryServicesDelegate.doFindSurgeryById(1);
//UserServicesDelegate.doBookSurgery(surgery, "coucou", 1);
	
	}
	
}
