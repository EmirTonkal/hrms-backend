package kodlamaio.hrms.Business.Concrete;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Business.Abstracts.JobTitleService;
import kodlamaio.hrms.Core.utilities.Business.BusinessRules;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.ErrorResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.JobTitleDao;
import kodlamaio.hrms.Entities.Concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}


	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult
				<List<JobTitle>>(this.jobTitleDao.findAll(),"Data Listelendi");
				
	}


	@Override
	public Result add(JobTitle jobTitle) {
		
Result result = BusinessRules.run(nullControl(jobTitle),titleRepeatControl(jobTitle));
		
		if(result.isSuccess()) {	
			
			jobTitleDao.save(jobTitle);
			return new SuccessResult("Eklendi");
			
		}
		return result;
	}
	
	
	
	//PRİVATE KURAL METOTLARI ------------------------------------------------------------------------------------------------------------------------------------------
	
		private Result nullControl(JobTitle jobTitle) {
			if(jobTitle.getTitle()==null || jobTitle.getTitle().isBlank()) {
				return new ErrorResult("Alanlar boş bırakılamaz");
			}
			return new SuccessResult();
		}
		
		private Result titleRepeatControl(JobTitle jobTitle) {
			if(jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count() !=0 ) {
				return new ErrorResult("bu pozisyon mevcut");
			}
			return new SuccessResult();
		}
}

