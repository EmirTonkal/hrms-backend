package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.JobTitle;
import kodlamaio.hrms.Entities.Concretes.School;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAll();

    Result add(School school);

}
