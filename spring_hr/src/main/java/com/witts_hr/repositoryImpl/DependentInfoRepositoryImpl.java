package com.emphr_hr.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.emphr_hr.entity.DependentInfo;
import com.emphr_hr.entity.Qualification;
import com.emphr_hr.repository.DependentInfoRepository;

@Repository
public class DependentInfoRepositoryImpl implements DependentInfoRepository{
	@PersistenceContext
	private EntityManager entityManager;

	private static List<DependentInfo> dependentInfos = new ArrayList<>();

	private static DependentInfo dependentInfo;

	@Override
	@Transactional
	public void save(DependentInfo dependentInfo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(dependentInfo);
	}

	@Override
	public List<DependentInfo> findByemployeeId(String employee_id) {
		Query query = this.entityManager.createQuery("SELECT d from DependentInfo d WHERE d.employee_id = ?1",
		DependentInfo.class);
		query.setParameter(1, employee_id);
		try {
			dependentInfos = query.getResultList();
		} catch (Exception e) {
			System.out.println("Exception");
			}
		return dependentInfos;
	}


	@Override
	@Transactional
	public void deleteById(long dependentInfo_id) {
		DependentInfo dependentInfo = findById(dependentInfo_id);

		if (dependentInfo != null) {
			this.entityManager.remove(dependentInfo);
		}
	}

	@Override
	@Transactional
	public DependentInfo findById(long dependentInfo_id) {
		Query query = this.entityManager.createQuery("SELECT d from DependentInfo d", DependentInfo.class);
		dependentInfos = query.getResultList();
		for (DependentInfo dependentInfo : dependentInfos) {
			if (dependentInfo.getDependentInfo_id() == dependentInfo_id) {
				return dependentInfo;
			}
		}

		return null;
	}


	@Override
	@Transactional
	public void update(DependentInfo dependentInfo, long dependentInfo_id) {
		DependentInfo dependentInfos = findById(dependentInfo.getDependentInfo_id());
		if (dependentInfos != null) {
			this.entityManager.merge(dependentInfo);
		}
	}

	@Transactional
	public DependentInfo findBydependentInfoId(long dependentInfo_id) {
		Query query = this.entityManager.createQuery("SELECT d from DependentInfo d WHERE d.dependentInfo_id = ?1",
		DependentInfo.class);
		query.setParameter(1, dependentInfo_id);
		try {
			dependentInfo = (DependentInfo) query.getSingleResult();
		} catch (Exception e) {
			// to log
		}
		return dependentInfo;
	}



}
