package kodlamaio.hrms.Business.Concrete;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.Entities.dtos.JobAdvertisementDetailsDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Business.Abstracts.JobAdvertisementService;
import kodlamaio.hrms.Core.utilities.Business.BusinessRules;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.ErrorResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.CityDao;
import kodlamaio.hrms.DataAccess.Abstracts.EmployerDao;
import kodlamaio.hrms.DataAccess.Abstracts.JobAdvertisementDao;
import kodlamaio.hrms.Entities.Concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,EmployerDao employerDao,CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"data listelendi");
		
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrue());
		
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueOrderByApplicationDeadlineAsc());
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueAndEmployer_Id(id));
	}

	@Override
	public DataResult<List<JobAdvertisementDetailsDtos>> getAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementDetailsDtos>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		Result result = BusinessRules.run( employerControl(jobAdvertisement.getEmployer().getId()),
				cityControl(jobAdvertisement.getCity().getId()),
				NullControl(jobAdvertisement),
				minSalaryControl(jobAdvertisement),
				quotaControl(jobAdvertisement),
				minMaxControl(jobAdvertisement),
				minEqualsMaxControl(jobAdvertisement));
		
		if(result.isSuccess()) {	
			
			jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("eklendi");
			
		}
		return result;
	}
	
	@Override
	public Result update(int jobAdvertisementId , JobAdvertisement jobAdvertisement) {
		
		Result result = BusinessRules.run(checkAplicationDeadline(jobAdvertisementId, jobAdvertisement));
		
		if(result.isSuccess()) {	
			

			jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("başarıyla güncellendi");
			
		}
		return result;
		

	}
	


	//PRİVATE ADD KURAL METOTLARI ------------------------------------------------------------------------------------------------------------------------------------------
	private Result employerControl(int id) {
		if(!employerDao.existsById(id)) {
			return new ErrorResult("böyle bir kullanıcı yok");
		}
		return new SuccessResult();
	}
	
	private Result cityControl(int id) {
		if(!cityDao.existsById(id)) {
			return new ErrorResult("böyle bir şehir yok");
		}
		return new SuccessResult();
	}
	
	private Result NullControl(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDescription() == null || jobAdvertisement.getDescription().isBlank()) {
			return new ErrorResult("iş tanımı alanı boş olamaz");
		}
		else if(jobAdvertisement.getMinSalary() ==null || jobAdvertisement.getMaxSalary() == null) {
			return new ErrorResult("maaş alanları doldurulmalıdır");
		}
		else if(jobAdvertisement.getApplicationDeadline() == null) {
			return new ErrorResult("son başvuru tarihi boş bırakılamaz");
		}
		
		return new SuccessResult();
	}
	
	private Result minSalaryControl(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary()<2820) {
			return new ErrorResult("minimum maaş girişi 2820 tl'den az olamaz");
		}
		return new SuccessResult();
	}
	
	private Result quotaControl(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getQuota()<1) {
			return new ErrorResult("açık pozisyon adedi 1'den küçük olamaz");
		}
		return new SuccessResult();
	}
	
	private Result minMaxControl(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary()>jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("minimum maaş maximum maaştan büyük olamaz");
		}
		return new SuccessResult();
	}
	
	private Result minEqualsMaxControl(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary().equals(jobAdvertisement.getMaxSalary())) {
			return new ErrorResult("minimum maaş maximum maaşa eşit olamaz");
		}
		return new SuccessResult();
	}



	//UPDATE METOTLARI -----------------------------------------------------------------------------------------------------------------------

	private Result checkAplicationDeadline(int jobAdvertisementId, JobAdvertisement jobAdvertisement) {
		
		JobAdvertisement result = jobAdvertisementDao.findById(jobAdvertisementId).get();
		
		result.setActive(jobAdvertisement.isActive());
		
		
		
		if(jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
			return new ErrorResult("ilanın tarihi geçmiş");
		}
		return new SuccessResult();
	}
	
	
	




}
