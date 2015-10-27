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
import entities.User;

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

	// ______________________________________________________________________________________________
	// _______________________________________PATIENT
	// ________________________________________________
	// ______________________________________________________________________________________________

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
	public Patient findPatientByPassportNumber(Integer nbPassport) {
		String jpql = "select p from Patient p where p.numPassport=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", nbPassport);
		return (Patient) query.getSingleResult();
	}
	


	@Override
	public User userIdentification(String login, String password) {
		User user = null;
		Query query = entityManager
				.createQuery("select u from User u where u.login=:l and u.password=:p ");
		query.setParameter("l", login).setParameter("p", password);

		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;

	}

}
