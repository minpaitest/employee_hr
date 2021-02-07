package com.emphr_hr.repositoryImpl;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.emphr_hr.entity.BankAccountInfo;
import com.emphr_hr.repository.BankRepository;

@Repository
public class BankRepositoryImpl implements BankRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	private static BankAccountInfo bankAccountInfo = null;

	@Override
	@Transactional
	public void save(BankAccountInfo bank_account_info, String employee_id) {
			this.entityManager.merge(bank_account_info);
	}

	@Override
	public BankAccountInfo findById(String employee_id) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT b from BankAccountInfo b WHERE b.employee_id = ?1",
				BankAccountInfo.class);
		query.setParameter(1, employee_id);
		try {
			bankAccountInfo = (BankAccountInfo) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		if (bankAccountInfo == null) {
			return null;
		}
		return bankAccountInfo;
	}

}