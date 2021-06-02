package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Ability;
import kodlamaio.hrms.Entities.Concretes.AbilityCandidate;

import java.util.List;

public interface AbilityCandidateService {

    DataResult<List<AbilityCandidate>> getAll();

    Result add(AbilityCandidate abilityCandidate);

}
