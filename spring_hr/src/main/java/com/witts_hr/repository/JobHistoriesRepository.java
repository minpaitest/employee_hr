package com.emphr_hr.repository;

import java.util.List;

import com.emphr_hr.entity.JobHistories;
import com.emphr_hr.entity.JobInfo;
import com.emphr_hr.entity.Jobs;
import com.emphr_hr.entity.UserJob;

public interface JobHistoriesRepository {
	
	List<UserJob> getJobHistoriesList(String employee_id);

	void insertJobInfo(Jobs jobs, JobHistories jobHistories);

	void deleteJobInfo(String jobId);

	Jobs findByJobId(String jobId);

	JobHistories findByJobHistoryId(String jobId);

	JobInfo findJobInfoByJobId(String job_id);

	void updateJobInfo(Jobs jobs, JobHistories jobHistories);

	int getLatestJobId();
}
