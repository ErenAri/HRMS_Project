package kodlamaIO.HRMS.business.abstracts;

import java.util.List;

import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entities.concretes.EmployerUser;

public interface EmployerUserService {
	DataResult<List<EmployerUser>> getAll();
	DataResult<List<EmployerUser>> findByEmailIs(String email);
	
	Result add(EmployerUser employerUser);
}
