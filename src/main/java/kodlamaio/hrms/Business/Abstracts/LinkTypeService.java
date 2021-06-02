package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.LinkType;
import kodlamaio.hrms.Entities.Concretes.School;

import java.util.List;

public interface LinkTypeService {

    DataResult<List<LinkType>> getAll();

    Result add(LinkType linkType);

}
