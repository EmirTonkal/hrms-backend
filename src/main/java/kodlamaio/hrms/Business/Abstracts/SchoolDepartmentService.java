package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.School;
import kodlamaio.hrms.Entities.Concretes.SchoolDepartment;

import java.util.List;

public interface SchoolDepartmentService {

    DataResult<List<SchoolDepartment>> getAll();

    Result add(SchoolDepartment schoolDepartment);

}
