package kodlamaIO.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaIO.HRMS.business.abstracts.CandidateUserService;
import kodlamaIO.HRMS.business.abstracts.EmailService;
import kodlamaIO.HRMS.business.concretes.CheckHelper.CandidateUserCheckHelper;
import kodlamaIO.HRMS.core.adapters.UserCheckService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.ErrorResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaIO.HRMS.core.utilities.results.SuccessResult;
import kodlamaIO.HRMS.dataAccess.abstracts.CandidateUserDao;
import kodlamaIO.HRMS.entities.concretes.CandidateUser;

@Service
public class CandidateUserManager implements CandidateUserService{
	
	private final CandidateUserDao candidateUserDao;
	private final UserCheckService userCheckService;
	private final EmailService emailService;
	

	public CandidateUserManager(CandidateUserDao candidateUserDao, UserCheckService userCheckService,
			EmailService emailService) {
		super();
		this.candidateUserDao = candidateUserDao;
		this.userCheckService = userCheckService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<CandidateUser>> getAll() {
		
		return new SuccessDataResult<>(this.candidateUserDao.findAll());
	}

	@Override
	public DataResult<List<CandidateUser>> findByEmailIs(String email) {
			
		return new SuccessDataResult<>(this.candidateUserDao.findByEmailIs(email));
	}

	@Override
	public DataResult<List<CandidateUser>> findByIdentityNumberIs(String identityNumber) {
		
		return new SuccessDataResult<>(this.candidateUserDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<Boolean> checkIfRealPerson(String nationalyIdentity, String firstName, String lastName,
			LocalDate dateOfBirthYear) {
		
		return new DataResult<>(this.userCheckService.checkIfRealPerson(nationalyIdentity, firstName, lastName, dateOfBirthYear),true);
	}

	@Override
	public Result add(CandidateUser candidateUser) {
		
		var checkEmail = this.findByEmailIs(candidateUser.getEmail()).getData().size() !=0;
		var checkIdentityNumber = this.findByIdentityNumberIs(candidateUser.getIdentityNumber()).getData().size() != 0;
		var checkUserRealOrNot = !this.checkIfRealPerson(candidateUser.getIdentityNumber(), candidateUser.getFirstName(), candidateUser.getLastName(), candidateUser.getDateOfBirth()).getData();
		var checkFields = !CandidateUserCheckHelper.allFieldsAreRequired(candidateUser);
		
		if(checkEmail || checkIdentityNumber || checkUserRealOrNot || checkFields) {
			
			String errorMessage = "";
			
			if (checkEmail || checkIdentityNumber) {
				errorMessage += "Zaten böyle bir Email veya TC no mevcuttur.";
			}
			if (checkUserRealOrNot) {
				errorMessage += "Böyle bir kişi mevcut değil";
			}
			if (checkFields) {
				errorMessage += "Tüm alanlar gereklidir";
			}
			return new ErrorResult(errorMessage);
		}
		
		this.candidateUserDao.save(candidateUser);
		return new SuccessResult(this.emailService.sendEmail(candidateUser).getMessage());
		
	}
	
}

