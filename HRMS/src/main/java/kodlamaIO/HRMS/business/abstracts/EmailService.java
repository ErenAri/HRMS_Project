package kodlamaIO.HRMS.business.abstracts;

import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entities.concretes.User;

public interface EmailService {
	Result sendEmail(User user);
}
