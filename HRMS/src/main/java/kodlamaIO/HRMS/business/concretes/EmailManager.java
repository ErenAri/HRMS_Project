package kodlamaIO.HRMS.business.concretes;

import kodlamaIO.HRMS.business.abstracts.EmailService;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.core.utilities.results.SuccessResult;
import kodlamaIO.HRMS.entities.concretes.User;

public class EmailManager implements EmailService{

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email başarı ile gönderildi: "+ user.getEmail());
	}

}
