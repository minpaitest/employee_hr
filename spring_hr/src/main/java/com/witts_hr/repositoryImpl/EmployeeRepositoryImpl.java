package com.emphr_hr.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.emphr_hr.entity.Employee;
import com.emphr_hr.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static Employee employee = null;

	private static List<Employee> employees = new ArrayList<>();

	@Override
	@Transactional
	public void save(String employee_id, Employee employee) {
		if (employee_id == "-1") {
			this.entityManager.persist(employee);
		} else {
			this.entityManager.merge(employee);
		}

	}

	@Override
	@Transactional
	public Employee findByemployeeId(String employee_id) {
		Query query = this.entityManager.createQuery("SELECT e from Employee e WHERE e.employee_id = ?1",
				Employee.class);
		query.setParameter(1, employee_id);
		try {
			employee = (Employee) query.getSingleResult();

		} catch (Exception e) {

		}
		if (employee == null) {
			return null;
		}
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		Query query = this.entityManager.createQuery("SELECT e from Employee e", Employee.class);
		employees = query.getResultList();
		return employees;
	}

	@Override
	@Transactional
	public void deleteById(String employee_id) {
		Employee employee = findByemployeeId(employee_id);

		if (employee != null) {
			this.entityManager.remove(employee);
		}

	}
	
	@Override
	public List<Employee> findByEmployeeId(String employee_id) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT e from Employee e WHERE e.employee_id = ?1 OR e.employee_name = ?1",
				Employee.class);
		query.setParameter(1, employee_id);
		try {
			employees = query.getResultList();
		} catch (Exception e) {
			// to log
		}
        return employees;
	}
}
