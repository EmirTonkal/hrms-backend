package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.LanguageCandiate;

import java.util.List;

public interface LanguageCandidateService {

    DataResult<List<LanguageCandiate>> getAll();

    Result add(LanguageCandiate languageCandiate);

}
