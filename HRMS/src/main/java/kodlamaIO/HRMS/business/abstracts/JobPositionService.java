package kodlamaIO.HRMS.business.abstracts;

import java.util.List;

import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobPosition>> findByPositionIs(String position);
	
	Result add(JobPosition jobPosition);
}
