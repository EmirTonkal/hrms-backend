package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.JobAdvertisement;
import kodlamaio.hrms.Entities.dtos.JobAdvertisementDetailsDtos;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadlineAsc();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployerId(int id);

	DataResult<List<JobAdvertisementDetailsDtos>> getAdvertisementWithEmployerDetails();
	
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(int jobAdvertisementId , JobAdvertisement jobAdvertisement);


	
	
	
}
