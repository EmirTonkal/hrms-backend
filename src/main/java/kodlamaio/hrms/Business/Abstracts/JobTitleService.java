package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	
	Result add(JobTitle jobTitle);
	
}
