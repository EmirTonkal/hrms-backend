package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Ability;
import kodlamaio.hrms.Entities.Concretes.Candidate;

import java.util.List;

public interface AbilityService {

    DataResult<List<Ability>> getAll();

    Result add(Ability ability);

}
