package kodlamaIO.HRMS.core.adapters;

import java.time.LocalDate;

public class FakeMernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(String nationaltId, String firstName, String lastName, LocalDate dateOfBirthYear) {
		// TODO Auto-generated method stub
		return true;
	}

}
