package tests.UserServices;

import java.util.Date;

import delegates.UserServicesDelegate;
import entities.Patient;

public class TestFindPatientByPassportNumber {

	public static void main(String[] args) {
Patient patientTest = new Patient();
patientTest.setCin(11616160);
patientTest.setCountry("Algeria");
patientTest.setDateOfBirth(new Date());
patientTest.setFirstName("Flen");
patientTest.setLastName("Foulen");
patientTest.setLogin("flenFoulen");
patientTest.setMail("flen@foulen.fr");
patientTest.setUserId(4);
patientTest.setNumPassport(131545);
patientTest.setPassword("passwordFlen");
UserServicesDelegate.doAddPatient(patientTest);


Patient trouvee=UserServicesDelegate.doFindPatientByPassportNumber(131545);
System.out.println(trouvee.getLastName() + "  " + trouvee.getFirstName());







	}

}
