package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.LinkTypeService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.LinkTypeDao;
import kodlamaio.hrms.Entities.Concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkTypeManager implements LinkTypeService {

    private LinkTypeDao linkTypeDao;
    @Autowired
    public LinkTypeManager(LinkTypeDao linkTypeDao) {
        this.linkTypeDao = linkTypeDao;
    }

    @Override
    public DataResult<List<LinkType>> getAll() {
        return new SuccessDataResult<List<LinkType>>(linkTypeDao.findAll(),"listelendi");
    }

    @Override
    public Result add(LinkType linkType) {
        linkTypeDao.save(linkType);
        return new SuccessResult("Başarıyla eklendi");
    }
}
