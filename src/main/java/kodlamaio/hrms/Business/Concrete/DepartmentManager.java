package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.DepartmentService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.DepartmentDao;
import kodlamaio.hrms.Entities.Concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;
    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }



    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<List<Department>>(departmentDao.findAll());
    }

    @Override
    public Result add(Department department) {
        departmentDao.save(department);
        return new SuccessResult("başarıyla eklendi");
    }
}
