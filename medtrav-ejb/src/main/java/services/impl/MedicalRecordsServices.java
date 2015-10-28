package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.MedicalRecords;
import services.interfaces.MedicalRecordsServicesLocal;
import services.interfaces.MedicalRecordsServicesRemote;

/**
 * Session Bean implementation class MedicalRecordsServices
 */
@Stateless
public class MedicalRecordsServices implements MedicalRecordsServicesRemote, MedicalRecordsServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
	
    public MedicalRecordsServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addMedicalRecords(MedicalRecords medicalRecords) {
		Boolean b= false;
		try {
			entityManager.merge(medicalRecords);
			b=true;
			
		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean updateMedicalRecords(MedicalRecords medicalRecords) {
		Boolean b= false;
		try {
			entityManager.merge(medicalRecords);
			b=true;
			
		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

}
