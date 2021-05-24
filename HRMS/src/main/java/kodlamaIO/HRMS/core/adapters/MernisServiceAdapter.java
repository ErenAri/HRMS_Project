package kodlamaIO.HRMS.core.adapters;

import java.time.LocalDate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(String nationaltId, String firstName, String lastName, LocalDate dateOfBirthYear) {
		//KPSPublicSoap soapClient = new KPSPublicSoap();
		
		KPSPublicSoapProxy soapClient = new KPSPublicSoapProxy();
		boolean result = true;
		
		try {
			result = soapClient.TCKimlikNoDogrula(Long.parseLong(nationaltId), firstName, lastName, dateOfBirthYear.getYear());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

}
