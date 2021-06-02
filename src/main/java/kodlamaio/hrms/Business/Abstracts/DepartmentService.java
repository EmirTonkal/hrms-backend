package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Department;
import kodlamaio.hrms.Entities.Concretes.School;
import kodlamaio.hrms.Entities.Concretes.SchoolDepartment;

import java.util.List;

public interface DepartmentService {

    DataResult<List<Department>> getAll();

    Result add(Department department);

}
