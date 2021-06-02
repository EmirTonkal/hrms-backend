package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Language;
import kodlamaio.hrms.Entities.Concretes.School;

import java.util.List;

public interface LanguageService {

    DataResult<List<Language>> getAll();

    Result add(Language language);
}
