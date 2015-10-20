package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;
import entities.Doctor;
import entities.Patient;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public UserServices() {
	}

	// Doctor Services
	@Override
	public boolean addDocor(Doctor doctor) {
		Boolean b = false;
		try {
			entityManager.persist(doctor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		Boolean b = false;
		try {
			entityManager.merge(doctor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean removeDoctor(Integer doctorId) {
		Boolean b = false;
		try {
			Doctor foundDoctor = entityManager.find(Doctor.class, doctorId);
			entityManager.remove(foundDoctor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Doctor findDoctorById(Integer id) {
		return entityManager.find(Doctor.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findDoctorsBySpecialty(String specialty) {
		String jpql = "select d from Doctor d where d.specialty=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", specialty);
		return query.getResultList();
	}

	@Override
	public boolean addPatient(Patient patient) {
		Boolean b = false;
		try {
			entityManager.persist(patient);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		Boolean b = false;
		try {
			entityManager.merge(patient);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean removePatient(Integer patientId) {
		Boolean b = false;
		try {
			Patient foundPatient = entityManager.find(Patient.class, patientId);
			entityManager.remove(foundPatient);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Patient findPatientById(Integer id) {
		return entityManager.find(Patient.class, id);
	}


}
