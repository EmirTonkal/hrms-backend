package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.School;
import kodlamaio.hrms.Entities.Concretes.SchoolCandidate;

import java.util.List;

public interface SchoolCandidateService {

    DataResult<List<SchoolCandidate>> getAll();

    Result add(SchoolCandidate schoolCandidate);

}
