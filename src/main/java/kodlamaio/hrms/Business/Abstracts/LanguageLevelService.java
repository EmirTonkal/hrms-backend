package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Language;
import kodlamaio.hrms.Entities.Concretes.LanguageLevel;

import java.util.List;

public interface LanguageLevelService {

    DataResult<List<LanguageLevel>> getAll();

    Result add(LanguageLevel languageLevel);
}
