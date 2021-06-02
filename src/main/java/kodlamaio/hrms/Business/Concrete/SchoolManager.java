package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.SchoolService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.SchoolDao;
import kodlamaio.hrms.Entities.Concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {


    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }


    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        schoolDao.save(school);
        return new SuccessResult("başarıyla eklendi");
    }
}
