package kodlamaio.hrms.Business.Concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Business.Abstracts.CandidateService;
import kodlamaio.hrms.Core.utilities.Business.BusinessRules;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.ErrorResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.CandidateDao;
import kodlamaio.hrms.Entities.Concretes.Candidate;
import kodlamaio.hrms.zMernis.UserValidationService;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserValidationService validationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,UserValidationService validationService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Data Listelendi");
		
	}

	@Override
	public Result add(Candidate candidate) {
		
		Result result = BusinessRules.run(identityNumberControl(candidate));
		
		if(result.isSuccess()) {	
			
			candidateDao.save(candidate);
			return new SuccessResult("Eklendi");
			
		}
		return result;
	}

	//PRİVATE KURAL METOTLARI ------------------------------------------------------------------------------------------------------------------------------------------

	private Result mernisControl(Candidate candidate) {
		
		if (validationService.validate(candidate) == false) {
			return new ErrorResult("Mernis doğrulaması gerçekleşmedi");
		}
		return new SuccessResult();	
	}
	
	private Result identityNumberControl(Candidate candidate) {
		
		if (candidate.getIdentificationNumber().length() != 11) {
			return new ErrorResult("Tc numarası 11 haneli olmalıdır.");
		}
		return new SuccessResult();	
	}
}

