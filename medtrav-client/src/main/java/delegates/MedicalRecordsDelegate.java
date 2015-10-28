package delegates;

import locator.ServiceLocator;
import services.interfaces.MedicalRecordsServicesRemote;
import entities.MedicalRecords;

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
}
