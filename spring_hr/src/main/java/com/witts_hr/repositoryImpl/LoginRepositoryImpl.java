package com.emphr_hr.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.emphr_hr.entity.Login;
import com.emphr_hr.repository.LoginRepository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private static Login login = null;

	private static List<Login> logins = new ArrayList<>();

	@Override
	public Login findByEmployeeId(String employee_id, String password) {
		Query query = this.entityManager.createQuery("SELECT e from Login e WHERE e.user_id = ?1 AND e.password = ?2 ",
				Login.class);
		query.setParameter(1, employee_id);
		query.setParameter(2, password);
		login = (Login) query.getSingleResult();
		if (login.getUser_id() != employee_id || login.getPassword() != password) {
			return null;
		}
		if (login == null) {
			return null;
		}
		return login;
	}
}