package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Candidate;


public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);
	
}
