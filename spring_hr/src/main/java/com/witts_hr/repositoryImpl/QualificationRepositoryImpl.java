package com.emphr_hr.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emphr_hr.entity.Qualification;
import com.emphr_hr.repository.QualificationRepository;

@Repository
public class QualificationRepositoryImpl implements QualificationRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private static List<Qualification> qualifications = new ArrayList<>();

	private static Qualification qualification;

	@Override
	@Transactional
	public void save(Qualification qualification) {
		this.entityManager.persist(qualification);

	}

	@Override
	@Transactional
	public void update(Qualification qualification, long qualification_id) {
		Qualification qualification2 = findById(qualification.getQualification_id());
		if (qualification2 != null) {
			this.entityManager.merge(qualification);
		}
	}

	@Override
	@Transactional
	public List<Qualification> findByemployeeId(String employee_id) {
		Query query = this.entityManager.createQuery("SELECT q from Qualification q WHERE q.employee_id = ?1",
				Qualification.class);
		query.setParameter(1, employee_id);
		try {
			qualifications = query.getResultList();
		} catch (Exception e) {
			// to log
		}
		return qualifications;
	}

	@Override
	@Transactional
	public void deleteById(long qualification_id) {
		Qualification qualification = findById(qualification_id);

		if (qualification != null) {
			this.entityManager.remove(qualification);
		}
	}

	@Override
	@Transactional
	public Qualification findById(long qualification_id) {
		Query query = this.entityManager.createQuery("SELECT q from Qualification q", Qualification.class);
		qualifications = query.getResultList();
		for (Qualification qualification : qualifications) {
			if (qualification.getQualification_id() == qualification_id) {
				return qualification;
			}
		}

		return null;
	}

	@Override
	@Transactional
	public Qualification findByqualificationId(long qualification_id) {
		Query query = this.entityManager.createQuery("SELECT q from Qualification q WHERE q.qualification_id = ?1",
				Qualification.class);
		query.setParameter(1, qualification_id);
		try {
			qualification = (Qualification) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		return qualification;
	}

}
