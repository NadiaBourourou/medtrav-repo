package tests.UserServices;

import java.sql.Date;

import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.Patient;

public class PopulateDb {
	public static void main(String[] args) {
		
		
		Patient patient1=new Patient();
	    patient1.setFirstName("Flen");
	    patient1.setLastName("Foulen");
	    patient1.setCin(14714750);
	    patient1.setCountry("Spain");
	    patient1.setDateOfBirth(Date.valueOf("1993-12-02"));
	    patient1.setLogin("Flen.Foulen");
	    patient1.setPassword("pwdFlen");
	    patient1.setMail("flenfoulen@gmail.com");
	    patient1.setNumPassport(96359);
	    

	    Patient patient2=new Patient();
	    patient2.setFirstName("Sam");
	    patient2.setLastName("Heinrich");
	    patient2.setCin(1000634);
	    patient2.setCountry("Germay");
	    patient2.setDateOfBirth(Date.valueOf("1984-6-12"));
	    patient2.setLogin("Sam.Heinrich");
	    patient2.setPassword("pwdSam");
	    patient2.setMail("SamHeinrich@gmail.com");
	    patient2.setNumPassport(121214);
	    
	    
	    
	    
	   // Patient patient3=new Patient();
	    // Patient patient4=new Patient();
	    
	    Doctor doctor1=new Doctor();
	    doctor1.setFirstName("Max");
	    doctor1.setLastName("Hunter");
	    doctor1.setCin(1940634);
	    doctor1.setDescription("Specialiste des maladies cardio-vasculaires");
	    doctor1.setLogin("max.hunter");
	    doctor1.setPassword("pwdMax");
	    doctor1.setMail("MaxHunter@gmail.com"); 
	    doctor1.setSpecialty("CardioVasculaire");
	  
	    

	    
	    
//	    Doctor doctor2=new Doctor();
//	    Doctor doctor3=new Doctor();
	    
	    UserServicesDelegate.doAddPatient(patient1);
	    UserServicesDelegate.doAddPatient(patient2); 
	    UserServicesDelegate.doaAddDocor(doctor1);
	    
		
	}

}
