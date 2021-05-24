package kodlamaIO.HRMS.business.concretes;

import java.util.List;

import kodlamaIO.HRMS.business.abstracts.EmailService;
import kodlamaIO.HRMS.business.abstracts.EmployerUserService;
import kodlamaIO.HRMS.business.concretes.CheckHelper.EmployerUserCheckHelper;
import kodlamaIO.HRMS.business.concretes.CheckHelper.StaffUserCheckHelper;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.ErrorResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaIO.HRMS.core.utilities.results.SuccessResult;
import kodlamaIO.HRMS.dataAccess.abstracts.EmployerUserDao;
import kodlamaIO.HRMS.entities.concretes.EmployerUser;

public class EmployerUserManager implements EmployerUserService{

	private final EmployerUserDao employerUserDao;
	private final EmailService emailService;
	
	public EmployerUserManager(EmployerUserDao employerUserDao, EmailService emailService) {
		super();
		this.employerUserDao = employerUserDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
			
		return new SuccessDataResult<>(this.employerUserDao.findAll());
	}

	@Override
	public DataResult<List<EmployerUser>> findByEmailIs(String email) {
			
		return new SuccessDataResult<>(this.employerUserDao.findByEmailIs(email));
	}

	@Override
	public Result add(EmployerUser employerUser) {
		var checkEmail = this.findByEmailIs(employerUser.getEmail()).getData().size()!=0;
		var checkFields = !EmployerUserCheckHelper.allFieldsAreRequired(employerUser);
		var staffConfirm = !StaffUserCheckHelper.confirmEmployer(employerUser);
		
		if(checkEmail || checkFields || staffConfirm) {
			String errorMessage = "";
			
			if(checkEmail) {
				errorMessage += "Böyle bir email mevcut!!!";
			}
			if (checkFields) {
				errorMessage += "Eksik veya hatalı yazım!!!";
			}
			
			if(staffConfirm) {
				errorMessage += "Kaydınız reddedildi!!!";
			}
			return new ErrorResult(errorMessage);
		}
		
		this.employerUserDao.save(employerUser);
		
		return new SuccessResult(this.emailService.sendEmail(employerUser).getMessage());	
		
	}

}
