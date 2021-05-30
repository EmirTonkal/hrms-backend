package kodlamaio.hrms.Business.Concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Business.Abstracts.CityService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.DataAccess.Abstracts.CityDao;
import kodlamaio.hrms.Entities.Concretes.City;


@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {

		return new SuccessDataResult<List<City>>(cityDao.findAll(),"Data Listelendi");
		
	}

}
