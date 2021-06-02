package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.LinkType;
import kodlamaio.hrms.Entities.Concretes.SocialMedia;

import java.util.List;

public interface SocialMediaService {

    DataResult<List<SocialMedia>> getAll();

    Result add(SocialMedia socialMedia);
}
