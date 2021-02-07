package com.emphr_hr.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emphr_hr.entity.EmergencyContact;
import com.emphr_hr.repository.EmergencyContactRepository;

@Repository
public class EmergencyContactRepositoryImpl implements EmergencyContactRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private static EmergencyContact emergencyContact = null;

	@Override
	@Transactional
	public void save(EmergencyContact emergencycontact, String employee_id) {
		this.entityManager.merge(emergencycontact);
	}

	@Override
	@Transactional
	public EmergencyContact findById(String employee_id) {
		Query query = this.entityManager.createQuery("SELECT c from EmergencyContact c WHERE c.employee_id = ?1",
				EmergencyContact.class);
		query.setParameter(1, employee_id);
		try {
			emergencyContact = (EmergencyContact) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		if (emergencyContact == null) {
			return null;
		}
		return emergencyContact;
	}

}