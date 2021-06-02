package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.SchoolCandidateService;
import kodlamaio.hrms.Business.Abstracts.SchoolDepartmentService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.SchoolCandidateDao;
import kodlamaio.hrms.DataAccess.Abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.Entities.Concretes.SchoolCandidate;
import kodlamaio.hrms.Entities.Concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolCandidateManager implements SchoolCandidateService {

    private SchoolCandidateDao schoolCandidateDao;
    @Autowired
    public SchoolCandidateManager(SchoolCandidateDao schoolCandidateDao) {
        this.schoolCandidateDao = schoolCandidateDao;
    }

    @Override
    public DataResult<List<SchoolCandidate>> getAll() {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.findAll());
    }

    @Override
    public Result add(SchoolCandidate schoolCandidate) {
        schoolCandidateDao.save(schoolCandidate);
        return new SuccessResult("eklendi");
    }
}
