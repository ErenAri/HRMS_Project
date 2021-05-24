package kodlamaIO.HRMS.core.adapters;

import java.time.LocalDate;

public interface UserCheckService {
	
	boolean checkIfRealPerson(String nationaltId,
			String firstName,
			String lastName,
			LocalDate dateOfBirthYear
			);

}
