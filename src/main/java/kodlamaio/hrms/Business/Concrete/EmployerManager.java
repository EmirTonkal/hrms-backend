package kodlamaio.hrms.Business.Concrete;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.hrms.Business.Abstracts.EmployerService;
import kodlamaio.hrms.Core.adaptors.emailAdaptor;
import kodlamaio.hrms.Core.utilities.Business.BusinessRules;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.ErrorResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.EmployerDao;
import kodlamaio.hrms.Entities.Concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private emailAdaptor adaptor;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,emailAdaptor adaptor) {
		super();
		this.employerDao = employerDao;
		this.adaptor = adaptor;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult
				<List<Employer>>(employerDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		Result result = BusinessRules.run(emailExist(employer.getEmail()),nullControl(employer));
		
		if(result.isSuccess()) {	
			

			employerDao.save(employer);
			return new SuccessResult("eklendi");
			
		}
		return result;
	}
	
	
	
	
	
	
	
	
	//PRİVATE KURAL METOTLARI ------------------------------------------------------------------------------------------------------------------------------------------
	
	private Result emailExist(String email) {
		if(employerDao.findAllByEmail(email).stream().count()!= 0) {
			return new ErrorResult("bu e mail mevcut");
		}
		return new SuccessResult();
	}
	
	private Result nullControl(Employer employer) {
		if(employer.getEmail()==null || employer.getEmail().isBlank()||
		   employer.getPassword()==null||employer.getPassword().isBlank()||
		   employer.getCompanyName()==null|| employer.getCompanyName().isBlank()||
		   employer.getWebAddress()==null||employer.getWebAddress().isBlank()) {
			
			return new ErrorResult("bu alanlar boş bırakılamaz");
		}
		return new SuccessResult();
	}
	
	private Result isRealEmployer(Employer employer) {
		
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
		
		if(!employer.getEmail().contains(employer.getWebAddress())) {
			return new ErrorResult("domain aynı değil");
		}
		else if(matcher.matches()) {
			return new ErrorResult("hata");
		}
		return new SuccessResult();
	}
}

