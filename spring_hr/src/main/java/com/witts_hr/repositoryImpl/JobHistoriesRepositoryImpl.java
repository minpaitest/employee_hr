package com.emphr_hr.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.emphr_hr.entity.JobHistories;
import com.emphr_hr.entity.JobInfo;
import com.emphr_hr.entity.Jobs;
import com.emphr_hr.entity.UserJob;
import com.emphr_hr.repository.JobHistoriesRepository;

@Repository
public class JobHistoriesRepositoryImpl implements JobHistoriesRepository {

	@PersistenceContext
	private EntityManager entityManager;
/*
	private static List<Jobs> employeesJobList = new ArrayList<>();
	private static List<JobHistories> jobHistoriesList = new ArrayList<>();

	private static Jobs jobs;
	private static JobHistories jobHistories;
*/

	private Jobs jobs;
	private JobHistories jobHistories;
	private JobInfo jobInfo;

	@Override
	@Transactional
	public List<UserJob> getJobHistoriesList(String employee_id) {

		List<Jobs> jobList = new ArrayList<>();
		List<JobHistories> jobHisList = new ArrayList<>();
		List<UserJob> userJobList = new ArrayList<>();
		List<Jobs> filterJobList = new ArrayList<>();

		jobList.clear();
		jobHisList.clear();
		userJobList.clear();
		filterJobList.clear();

		Query query = this.entityManager.createQuery(
				"SELECT h from JobHistories h WHERE h.employeeId = ?1 ORDER BY h.startDate ASC",
				JobHistories.class);
		query.setParameter(1, employee_id);

		try {
			/*
			results = entityManager.createQuery(
					"SELECT j.job_title, j.job_content, h.department_id, h.start_date " + 
					"FROM JobHistories h, Jobs j " + 
					"WHERE h.job_id = j.job_id " +
					"AND h.employee_id = " + employee_id).getResultList();
			*/

			if(!query.getResultList().isEmpty()) {
				jobHisList = query.getResultList();

				Query query2 = this.entityManager.createQuery("SELECT j from Jobs j", Jobs.class);

				jobList = query2.getResultList();

				for(int i = 0; i < jobHisList.size(); i++) {
					String historyJobId = jobHisList.get(i).getJobId();
					for(Jobs tempJobs : jobList) {
						if(historyJobId.equals(tempJobs.getJobId())) {
							filterJobList.add(tempJobs);
						}
					}
				}

				for(int i = 0; i < jobHisList.size(); i++) {
					UserJob userJob = new UserJob();
					userJob.setJobId(filterJobList.get(i).getJobId());
					userJob.setJobTitle(filterJobList.get(i).getJobTitle());
					userJob.setJobContent(filterJobList.get(i).getJobContent());
					userJob.setDepartmentId(jobHisList.get(i).getDepartmentId());
					userJob.setStartDate(jobHisList.get(i).getStartDate());

					userJobList.add(userJob);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userJobList;
	}

	@Override
	@Transactional
	public void insertJobInfo(Jobs jobs, JobHistories jobHistories) {

		try {
			this.entityManager.persist(jobs);
			this.entityManager.persist(jobHistories);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void deleteJobInfo(String jobId) {

		Jobs jobs = findByJobId(jobId);
		JobHistories jobHistories = findByJobHistoryId(jobId);

		if(jobs != null && jobHistories != null) {
			this.entityManager.remove(jobs);
			this.entityManager.remove(jobHistories);
		}
	}

	@Override
	@Transactional
	public Jobs findByJobId(String jobId) {
		Query query = this.entityManager.createQuery("SELECT j FROM Jobs j WHERE j.jobId = ?1", Jobs.class);
		query.setParameter(1, jobId);
		try {
			jobs = (Jobs) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs;
	}

	@Override
	@Transactional
	public JobHistories findByJobHistoryId(String jobId) {
		Query query = this.entityManager.createQuery("SELECT h FROM JobHistories h WHERE h.job_id = ?1", JobHistories.class);
		query.setParameter(1, jobId);
		try {
			jobHistories = (JobHistories) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobHistories;
	}

	@Override
	@Transactional
	public JobInfo findJobInfoByJobId(String job_id) {

		jobs = new Jobs();
		jobHistories = new JobHistories();

		jobs = findByJobId(job_id);
		jobHistories = findByJobHistoryId(job_id);

		if(jobs != null && jobHistories != null) {
			jobInfo = new JobInfo();
			jobInfo.setTempId(jobs.getJobsTempId());
			jobInfo.setJobId(jobs.getJobId());
			jobInfo.setJobTitle(jobs.getJobTitle());
			jobInfo.setJobContent(jobs.getJobContent());
			jobInfo.setJobTechnology(jobs.getJobTechnology());
			jobInfo.setDepartmentName(jobHistories.getDepartmentId());
			jobInfo.setJobHistoriesStartDate(jobHistories.getStartDate());
			jobInfo.setJobHistoriesExpieredDate(jobHistories.getEndDate());
		}

		return jobInfo;
	}

	@Override
	@Transactional
	public void updateJobInfo(Jobs jobs, JobHistories jobHistories) {
		Jobs findJobs = findByJobId(jobs.getJobId());
		JobHistories findJobHistory = findByJobHistoryId(jobs.getJobId());
		if(findJobs != null && findJobHistory != null) {
			this.entityManager.merge(jobs);
			this.entityManager.merge(jobHistories);
		}
	}

	@Override
	public int getLatestJobId() {
		JobHistories result = new JobHistories();

		try {
			Query query = this.entityManager.createQuery(
					"SELECT h from JobHistories h ORDER BY h.job_id DESC",
					JobHistories.class).setMaxResults(1);
			result = (JobHistories) query.getSingleResult();

			if(result.getTempId() == 0L || result == null || StringUtils.isEmpty(result.getJobId())) {
				return -1;
			}

		} catch (NoResultException e) {
			return -1;
		}

		return Integer.parseInt(result.getJobId());
	}
}
