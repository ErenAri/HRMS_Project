package kodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaIO.HRMS.business.abstracts.JobPositionService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.ErrorResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaIO.HRMS.core.utilities.results.SuccessResult;
import kodlamaIO.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlamaIO.HRMS.entities.concretes.JobPosition;

public class JobPositionManager implements JobPositionService{

	private final JobPositionDao  jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
			
		return new SuccessDataResult<>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<List<JobPosition>> findByPositionIs(String position) {
				
		return new SuccessDataResult<>(this.jobPositionDao.findByPositionIs(position));
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(this.findByPositionIs(jobPosition.getPosition()).getData().size()!=0) {
			return new ErrorResult("Bu iş zaten mevcut!!!");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İşlem başarılı ");
	}

}
