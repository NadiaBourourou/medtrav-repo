package delegates;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import locator.ServiceLocator;
import services.interfaces.MedicalRecordsServicesRemote;
import entities.MedicalRecords;
import entities.Patient;

public class MedicalRecordsDelegate {
	public static final String jndiName = "/medtrav-ejb/MedicalRecordsServices!services.interfaces.MedicalRecordsServicesRemote";

	public static MedicalRecordsServicesRemote getProxy() {
		return (MedicalRecordsServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public static void doAddMedicalRecords(MedicalRecords medicalRecords) {
		getProxy().addMedicalRecords(medicalRecords);
	}

	public static void doUpdateMedicalRecords(MedicalRecords medicalRecords) {
		getProxy().updateMedicalRecords(medicalRecords);
	}
	
	public static MedicalRecords doFindMedicalRecordsByPatientId (Integer patientId){
		return getProxy().findMedicalRecordsByPatientId(patientId);
	}
	
	public static byte[] doDownloadAnalysis (Integer id) {
		return getProxy().downloadAnalysis(id);
	}
	
	public static byte[] doDownloadPatientFile (Integer id) {
		return getProxy().downloadPatientFile(id);
	}
	
	public static List<Patient> doListAssignedPatientsToDoctor(int idDoctor) {
		return getProxy().listAssignedPatientsToDoctor(idDoctor);
	}
	
	public static Patient doFindPatientByFirstNameAndLastName(String FirstName, String LastName) {
		return getProxy().findPatientByFirstNameAndLastName(FirstName, LastName);
	}
}
