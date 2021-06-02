package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Entities.Concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
}
