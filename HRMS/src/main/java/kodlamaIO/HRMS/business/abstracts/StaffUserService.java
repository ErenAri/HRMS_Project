package kodlamaIO.HRMS.business.abstracts;

import java.util.List;

import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.entities.concretes.EmployerUser;
import kodlamaIO.HRMS.entities.concretes.StaffUser;

public interface StaffUserService {
	DataResult<List<StaffUser>> getAll();
	DataResult<Boolean> confirmEmployer(StaffUser staffUser, EmployerUser confirmedEmployerUser);
}
