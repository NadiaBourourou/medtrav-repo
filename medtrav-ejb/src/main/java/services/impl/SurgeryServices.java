package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Surgery;
import services.interfaces.SurgeryServicesLocal;
import services.interfaces.SurgeryServicesRemote;

/**
 * Session Bean implementation class SurgeryServices
 */
@Stateless
public class SurgeryServices implements SurgeryServicesRemote,
		SurgeryServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SurgeryServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Surgery findSurgeryById(Integer idSurgery) {
		return entityManager.find(Surgery.class, idSurgery);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Surgery> findAllSurgeriesByDoctorId(Integer id) {
		String jpql = "select s from Surgery s where s.doctor.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Surgery> findAllSurgeriesByMedicalRecordsId(
			Integer id) {
		String jpql = "select s from Surgery s where s.medicalRecords.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

}
