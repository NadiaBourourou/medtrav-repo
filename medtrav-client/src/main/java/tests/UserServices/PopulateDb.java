package tests.UserServices;

import java.sql.Date;
import java.util.List;

import delegates.TreatmentServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Doctor;
import entities.Patient;
import entities.Procedure;
import entities.Treatment;

public class PopulateDb {
	private static List<Treatment> treatments;
	
	
	@SuppressWarnings("null")
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
	    doctor1.setLogin("frmWelcomeToMedtrav");
	    doctor1.setPassword("pwdMax");
	    doctor1.setMail("MaxHunter@gmail.com"); 
	    doctor1.setSpecialty("CardioVasculaire");
	  
	    
	   Procedure procedure1=new Procedure();
	procedure1.setName("Cosmetic and plastic surgery");

	
	Treatment treatment1_1=new Treatment();
	treatment1_1.setName("Botox");
	treatment1_1.setDescription("look younger blablabla");
	treatment1_1.setProcedure(procedure1);

	Treatment treatment2_1=new Treatment();
	treatment2_1.setName("Body lift");
	treatment2_1.setDescription("will see later on");
	treatment2_1.setProcedure(procedure1);


	
TreatmentServicesDelegate.doAssignProcedureToTreatment(treatment1_1, 1);
TreatmentServicesDelegate.doAssignProcedureToTreatment(treatment2_1, 1);
	

	
	
	

	    
//	    Doctor doctor2=new Doctor();
//	    Doctor doctor3=new Doctor();
	    
	    UserServicesDelegate.doAddPatient(patient1);
	    UserServicesDelegate.doAddPatient(patient2); 
	    UserServicesDelegate.doaAddDocor(doctor1);
	    TreatmentServicesDelegate.doAddProcedure(procedure1);
	    TreatmentServicesDelegate.doAddTreatment(treatment1_1);
	    TreatmentServicesDelegate.doAddTreatment(treatment2_1);
	    
	    
	   
	    
	    
		
	}

}
