package com.emphr_hr.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.emphr_hr.entity.EmployeeInsurance;
import com.emphr_hr.repository.EmployeeInsuranceRepository;

@Repository
public class EmployeeInsurancePensionRepositoryImpl implements EmployeeInsuranceRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static EmployeeInsurance employeeInsurance = null;

	@Override
	@Transactional
	public EmployeeInsurance findById(String employee_id) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT e from EmployeeInsurance e WHERE e.employee_id = ?1",
				EmployeeInsurance.class);
		query.setParameter(1, employee_id);
		try {
			employeeInsurance = (EmployeeInsurance) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		if (employeeInsurance == null) {
			return null;
		}
		return employeeInsurance;
	}

	@Override
	@Transactional
	public void save(EmployeeInsurance employeeInsurance, String id) {
		// TODO Auto-generated method stub
		if (id == "-1") {
			this.entityManager.persist(employeeInsurance);
		} else {
			this.entityManager.merge(employeeInsurance);
		}
	}

}
