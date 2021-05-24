package kodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaIO.HRMS.business.abstracts.JobTitleService;
import kodlamaIO.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaIO.HRMS.entities.concretes.JobTitle;

public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {
		
		return this.jobTitleDao.findAll();
	}

	@Override
	public List<JobTitle> findByTitleIs() {
		// TODO Auto-generated method stub
		return null;
	}

}
