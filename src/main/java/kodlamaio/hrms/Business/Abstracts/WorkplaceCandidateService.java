package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Workplace;
import kodlamaio.hrms.Entities.Concretes.WorkplaceCandidate;

import java.util.List;

public interface WorkplaceCandidateService {

    DataResult<List<WorkplaceCandidate>> getAll();

    Result add(WorkplaceCandidate workplaceCandidate);
}
