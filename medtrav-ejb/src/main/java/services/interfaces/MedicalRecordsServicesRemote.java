package services.interfaces;

import javax.ejb.Remote;

import entities.MedicalRecords;

@Remote
public interface MedicalRecordsServicesRemote {
	Boolean addMedicalRecords(MedicalRecords medicalRecords);
	Boolean updateMedicalRecords(MedicalRecords medicalRecords);

}