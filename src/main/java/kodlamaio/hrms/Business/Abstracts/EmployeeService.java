package kodlamaio.hrms.Business.Abstracts;

import java.util.List;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	
	Result add(Employee employee);
	
}
