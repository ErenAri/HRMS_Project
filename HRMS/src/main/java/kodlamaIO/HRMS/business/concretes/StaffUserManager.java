package kodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaIO.HRMS.business.abstracts.StaffUserService;
import kodlamaIO.HRMS.business.concretes.CheckHelper.StaffUserCheckHelper;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaIO.HRMS.dataAccess.abstracts.StaffUserDao;
import kodlamaIO.HRMS.entities.concretes.EmployerUser;
import kodlamaIO.HRMS.entities.concretes.StaffUser;

public class StaffUserManager implements StaffUserService{

	private final StaffUserDao staffUserDao;
	
	@Autowired
	public StaffUserManager(StaffUserDao staffUserDao) {
		this.staffUserDao =staffUserDao;
	}
	
	@Override
	public DataResult<List<StaffUser>> getAll() {	
		return new SuccessDataResult<>(this.staffUserDao.findAll());
	}

	@Override
	public DataResult<Boolean> confirmEmployer(StaffUser staffUser, EmployerUser confirmedEmployerUser) {
		return new SuccessDataResult<>(StaffUserCheckHelper.confirmEmployer(confirmedEmployerUser));
	}

}
