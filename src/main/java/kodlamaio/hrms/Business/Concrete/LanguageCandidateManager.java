package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.LanguageCandidateService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.LanguageCandidateDao;
import kodlamaio.hrms.Entities.Concretes.LanguageCandiate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageCandidateManager implements LanguageCandidateService {

    private LanguageCandidateDao languageCandidateDao;
    @Autowired
    public LanguageCandidateManager(LanguageCandidateDao languageCandidateDao) {
        this.languageCandidateDao = languageCandidateDao;
    }



    @Override
    public DataResult<List<LanguageCandiate>> getAll() {
        return new SuccessDataResult<List<LanguageCandiate>>(languageCandidateDao.findAll(),"İş arayan diller listelendi");
    }

    @Override
    public Result add(LanguageCandiate languageCandiate) {
        languageCandidateDao.save(languageCandiate);
        return new SuccessResult("başarıyla eklendi");
    }
}
