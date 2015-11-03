package tests.UserServices;

import java.sql.Date;
import java.util.List;

import delegates.TreatmentServicesDelegate;
import delegates.UserServicesDelegate;
import entities.Administrator;
import entities.Doctor;
import entities.Patient;
import entities.Procedure;
import entities.RoleType;
import entities.Treatment;

public class PopulateDb {
	private static List<Treatment> treatments;

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Patient patient1 = new Patient();
		patient1.setFirstName("Flen");
		patient1.setLastName("Foulen");
		patient1.setCin("14714750");
		patient1.setCountry("Spain");
		patient1.setDateOfBirth(Date.valueOf("1993-12-02"));
		patient1.setLogin("Flen.Foulen");
		patient1.setPassword("pwdFlen");
		patient1.setMail("flenfoulen@gmail.com");
		patient1.setNumPassport(96359);
		patient1.setRole(RoleType.PATIENT);

		Patient patient2 = new Patient();
		patient2.setFirstName("Sam");
		patient2.setLastName("Heinrich");
		patient2.setCin("1000634");
		patient2.setCountry("Germay");
		patient2.setDateOfBirth(Date.valueOf("1984-6-12"));
		patient2.setLogin("Sam.Heinrich");
		patient2.setPassword("pwdSam");
		patient2.setMail("SamHeinrich@gmail.com");
		patient2.setNumPassport(121214);
		patient2.setRole(RoleType.PATIENT);

		Doctor doctor1 = new Doctor();
		doctor1.setFirstName("Max");
		doctor1.setLastName("Hunter");
		doctor1.setCin("1940634");
		doctor1.setDescription("Specialiste des maladies cardio-vasculaires");
		doctor1.setLogin("Max.Hunter");
		doctor1.setPassword("pwdMax");
		doctor1.setMail("MaxHunter@gmail.com");
		doctor1.setSpecialty("CardioVasculaire");
		doctor1.setRole(RoleType.DOCTOR);

		Doctor doctor2 = new Doctor();
		doctor2.setFirstName("Mehdi");
		doctor2.setLastName("Achek");
		doctor2.setCin("14756367");
		doctor2.setDescription("Anesthesiste, bloc operatoire");
		doctor2.setLogin("Achek");
		doctor2.setPassword("achek");
		doctor2.setMail("Mehdiachek@gmail.com");
		doctor2.setSpecialty("Anesthesiste");
		doctor2.setRole(RoleType.DOCTOR);

		Administrator admin = new Administrator();
		admin.setFirstName("Sayed");
		admin.setLastName("El Moudir");
		admin.setLogin("Administrator");
		admin.setPassword("pwdAdmin");
		admin.setMail("admin@admin.net");
		admin.setCin("10203060");
		admin.setRole(RoleType.ADMINISTRATOR);

		Procedure procedure1 = new Procedure();
		procedure1.setName("Cosmetic and plastic surgery");

		Treatment treatment1_1 = new Treatment();
		treatment1_1.setName("Abdominoplasty");
		treatment1_1
				.setDescription("Get rid of your belly, time for effortless kickass abs");
		treatment1_1.setProcedure(procedure1);

		Treatment treatment2_1 = new Treatment();
		treatment2_1.setName("Body lift");
		treatment2_1.setDescription("will see later on");

		Treatment treatment3_1 = new Treatment();
		treatment3_1.setName("Botox");
		treatment3_1.setDescription("Say no to aging");

		Procedure procedure2 = new Procedure();

		procedure2.setName("Cardiology and cardiovascular surgery");

		Treatment treatment1_2 = new Treatment();
		treatment1_2.setName("Laser treatment of bladder cancer");
		treatment1_2
				.setDescription("Get rid of your belly, time for effortless kickass abs");

		Treatment treatment2_2 = new Treatment();
		treatment2_2.setName("Venous stenting");

		Treatment treatment3_2 = new Treatment();
		treatment3_2.setName("VATS");
		treatment3_2.setDescription("Video assisted of thoracic surgery");

		Procedure procedure3 = new Procedure();
		procedure3.setName("Urology");

		Treatment treatment1_3 = new Treatment();
		treatment1_3.setName("Laser treatment of bladder cancer");

		Treatment treatment2_3 = new Treatment();
		treatment2_3.setName("Vasectomy");

		UserServicesDelegate.doAddPatient(patient1);
		UserServicesDelegate.doAddPatient(patient2);
		UserServicesDelegate.doaAddDocor(doctor1);
		UserServicesDelegate.doAddAdmin(admin);

		TreatmentServicesDelegate.doAddProcedure(procedure1);
		TreatmentServicesDelegate.doAddProcedure(procedure2);
		TreatmentServicesDelegate.doAddProcedure(procedure3);

		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment1_1, 1);
		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment2_1, 1);
		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment3_1, 1);

		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment1_2, 2);
		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment2_2, 2);
		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment3_2, 2);

		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment1_3, 3);
		TreatmentServicesDelegate.doAddTreatmentAndAssignItToProcedure(
				treatment2_3, 3);

	}

}
