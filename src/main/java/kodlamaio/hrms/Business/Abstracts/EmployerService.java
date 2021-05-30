package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	
}
