package kodlamaIO.HRMS.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entities.concretes.CandidateUser;

public interface CandidateUserService {
	DataResult<List<CandidateUser>> getAll();
	DataResult<List<CandidateUser>> findByEmailIs(String email);
	DataResult<List<CandidateUser>> findByIdentityNumberIs(String identityNumber);
	DataResult<Boolean> checkIfRealPerson(String nationalyIdentity, String firstName, String lastName, LocalDate dateOfBirthYear);
	
	Result add(CandidateUser candidateUser);
}
