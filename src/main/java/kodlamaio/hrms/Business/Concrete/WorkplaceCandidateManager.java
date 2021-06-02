package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.WorkplaceCandidateService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.WorkplaceCandidateDao;
import kodlamaio.hrms.Entities.Concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkplaceCandidateManager implements WorkplaceCandidateService {

    private WorkplaceCandidateDao workplaceCandidateDao;
    @Autowired
    public WorkplaceCandidateManager(WorkplaceCandidateDao workplaceCandidateDao) {
        this.workplaceCandidateDao = workplaceCandidateDao;
    }



    @Override
    public DataResult<List<WorkplaceCandidate>> getAll() {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.findAll(),"listelendi");
    }

    @Override
    public Result add(WorkplaceCandidate workplaceCandidate) {
        workplaceCandidateDao.save(workplaceCandidate);
        return new SuccessResult("başarıyla eklendi");
    }
}
