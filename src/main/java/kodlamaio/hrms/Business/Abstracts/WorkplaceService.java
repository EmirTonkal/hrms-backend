package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Ability;
import kodlamaio.hrms.Entities.Concretes.Workplace;

import java.util.List;

public interface WorkplaceService {

    DataResult<List<Workplace>> getAll();

    Result add(Workplace workplace);

}
