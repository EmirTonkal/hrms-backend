package kodlamaio.hrms.zMernis;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.Entities.Concretes.Candidate;

@Service
public class UserValidationManager implements UserValidationService {

	@Override
	public boolean validate(Candidate candidate) {
		
	if (candidate.getFirstName()=="masum" &&
			candidate.getIdentificationNumber()=="12345678912") {
		
		return true;
		
	}
	else {
		
		return false;
	    }
	}
}
