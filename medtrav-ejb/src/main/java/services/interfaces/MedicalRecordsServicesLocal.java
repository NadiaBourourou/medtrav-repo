package services.interfaces;

import javax.ejb.Local;

import entities.MedicalRecords;

@Local
public interface MedicalRecordsServicesLocal {
	Boolean addMedicalRecords(MedicalRecords medicalRecords);
	Boolean updateMedicalRecords(MedicalRecords medicalRecords);

}
