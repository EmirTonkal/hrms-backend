package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.WorkplaceService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.WorkplaceDao;
import kodlamaio.hrms.Entities.Concretes.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkplaceManager implements WorkplaceService {

    private WorkplaceDao workplaceDao;
    @Autowired
    public WorkplaceManager(WorkplaceDao workplaceDao) {
        this.workplaceDao = workplaceDao;
    }

    @Override
    public DataResult<List<Workplace>> getAll() {
        return new SuccessDataResult<List<Workplace>>(workplaceDao.findAll());
    }

    @Override
    public Result add(Workplace workplace) {
        workplaceDao.save(workplace);
        return new SuccessResult("başarıyla eklendi");
    }
}
