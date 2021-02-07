package com.emphr_hr.repositoryImpl;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emphr_hr.entity.EmployeeInsurance;
import com.emphr_hr.entity.HealthInsurance;
import com.emphr_hr.repository.HealthInsuranceRepository;

@Repository
public class HealthInsurancePensionRepositoryImpl implements HealthInsuranceRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static HealthInsurance healthInsurance = null;

	@Override
	@Transactional
	public void save(HealthInsurance healthInsurance, String id) {
		// TODO Auto-generated method stub
		if (id == "-1") {
			this.entityManager.persist(healthInsurance);
		} else {
			this.entityManager.merge(healthInsurance);
		}
	}

	@Override
	@Transactional
	public HealthInsurance findById(String employee_id) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT h from HealthInsurance h WHERE h.employee_id = ?1",
				HealthInsurance.class);
		query.setParameter(1, employee_id);
		try {
			healthInsurance = (HealthInsurance) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		if (healthInsurance == null) {
			return null;
		}
		return healthInsurance;
	}

}
