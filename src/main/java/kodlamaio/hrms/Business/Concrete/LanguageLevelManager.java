package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.LanguageLevelService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.LanguageLevelDao;
import kodlamaio.hrms.Entities.Concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LanguageLevelManager implements LanguageLevelService {

    private LanguageLevelDao languageLevelDao;
    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
        this.languageLevelDao = languageLevelDao;
    }



    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll());
    }

    @Override
    public Result add(LanguageLevel languageLevel) {
        languageLevelDao.save(languageLevel);
        return new SuccessResult("başarıyla eklendi");
    }
}
