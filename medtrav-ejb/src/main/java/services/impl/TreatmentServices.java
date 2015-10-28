package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.TreatmentServicesRemote;
import entities.Procedure;
import entities.Treatment;

/**
 * Session Bean implementation class TreatmentServices
 */
@Stateless
public class TreatmentServices implements TreatmentServicesRemote {

	@PersistenceContext
	EntityManager entityManager;

	public TreatmentServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addTreatment(Treatment treatment) {
		Boolean b = false;
		try {
			entityManager.persist(treatment);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean addProcedure(Procedure procedure) {
		Boolean b = false;
		try {
			entityManager.persist(procedure);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	public Boolean assignProcedureToTreatment(Treatment newTreatment,
			Integer procedureId) {
		Boolean b = false;
		try {
			Procedure procedure = entityManager.find(Procedure.class,
					procedureId);
			newTreatment.setProcedure(procedure);
			entityManager.merge(newTreatment);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Treatment> findAllTreatmentsByProcedureId(Integer procedureId) {
		String jpql = "select t from Treatment t where t.procedure.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", procedureId);
		return query.getResultList();
	}

	// @Override
	// public Boolean assignTreatmentToProcedure(Treatment treatment, Integer
	// procedureId) {
	// Boolean b = false;
	// try {
	// Procedure procedure = entityManager.find(Procedure.class, procedureId);
	// List<Treatment> treatments = findAllTreatmentsByProcedureId(procedureId);
	// treatments.add(treatment);
	// procedure.linkTreatmentsToThisProcedure(treatments);l
	// entityManager.merge(procedure);
	// b = true;
	// } catch (Exception e) {
	// }
	// return b;
	// }

	@SuppressWarnings("unchecked")
	@Override
	public List<Procedure> findAllProcedures() {
		String jpql = "select p from Procedure p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	public String getTreatmentDescription(Integer treatmentId) {
		Treatment treatment = entityManager.find(Treatment.class, treatmentId);
		return treatment.getDescription();
	}

}
