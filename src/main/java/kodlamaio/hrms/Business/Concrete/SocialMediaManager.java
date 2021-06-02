package kodlamaio.hrms.Business.Concrete;

import kodlamaio.hrms.Business.Abstracts.SocialMediaService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.Core.utilities.results.SuccessResult;
import kodlamaio.hrms.DataAccess.Abstracts.SocialMediaDao;
import kodlamaio.hrms.Entities.Concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;
    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        this.socialMediaDao = socialMediaDao;
    }



    @Override
    public DataResult<List<SocialMedia>> getAll() {
        return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.findAll(),"listelendi");
    }

    @Override
    public Result add(SocialMedia socialMedia) {
        socialMediaDao.save(socialMedia);
        return new SuccessResult("Başarıyla eklendi");
    }
}
