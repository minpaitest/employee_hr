package com.emphr_hr.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emphr_hr.entity.BasicPension;
import com.emphr_hr.repository.BasicPensionRepository;

@Repository
public class BasicPensionRepositoryImpl implements BasicPensionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static BasicPension basicpension = null;

	@Override
	@Transactional
	public void save(BasicPension basicPension, String id) {
		if (id == "-1") {
			this.entityManager.persist(basicPension);
		} else {
			this.entityManager.merge(basicPension);
		}

	}

	@Override
	@Transactional
	public BasicPension findById(String employee_id) {
		Query query = this.entityManager.createQuery("SELECT p from BasicPension p WHERE p.employee_id = ?1",
				BasicPension.class);
		query.setParameter(1, employee_id);
		try {
			basicpension = (BasicPension) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		if (basicpension == null) {
			return null;
		}
		return basicpension;
	}

}
