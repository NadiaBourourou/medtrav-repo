package tests.UserServices;

import delegates.SurgeryServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Patient;

public class TestFindPatientByPassportNumber {

	public static void main(String[] args) {

		Patient trouvee = UserServicesDelegate
				.doFindPatientByPassportNumber(121214);
		System.out.println(trouvee.getLastName() + "  "
				+ trouvee.getFirstName());

	int taille=SurgeryServicesDelegate.doFindAllTreatmentsByProcedureId(1).size();
for (int i=0;i<taille;i++)
{
System.out.println(SurgeryServicesDelegate.doFindAllTreatmentsByProcedureId(1).get(i).toString());	

}


	}

}