package kodlamaIO.HRMS.business.abstracts;

import java.util.List;

import kodlamaIO.HRMS.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
	List<JobTitle> findByTitleIs();
}
