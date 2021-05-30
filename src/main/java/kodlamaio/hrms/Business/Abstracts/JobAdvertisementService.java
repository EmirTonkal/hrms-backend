package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadlineAsc();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployerId(int id);
	
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(int jobAdvertisementId , JobAdvertisement jobAdvertisement);
	
	
	
}
