package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.AbilityCandidateService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.AbilityCandidateDao;
import kodlamaio.hrms.Entities.Concretes.AbilityCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbilityCandidateManager implements AbilityCandidateService {

    private AbilityCandidateDao abilityCandidateDao;
    @Autowired
    public AbilityCandidateManager(AbilityCandidateDao abilityCandidateDao) {
        this.abilityCandidateDao = abilityCandidateDao;
    }



    @Override
    public DataResult<List<AbilityCandidate>> getAll() {
        return new SuccessDataResult<List<AbilityCandidate>>(abilityCandidateDao.findAll(),"kullanıcı yetenekleri listelendi");
    }

    @Override
    public Result add(AbilityCandidate abilityCandidate) {
        abilityCandidateDao.save(abilityCandidate);
        return new SuccessResult("başarıyla eklendi");
    }
}
