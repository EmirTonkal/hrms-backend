package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.SchoolDepartmentService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.Entities.Concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

    private SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
    }


    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<List<SchoolDepartment>>(schoolDepartmentDao.findAll());
    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult("başarıyla eklendi");
    }
}
