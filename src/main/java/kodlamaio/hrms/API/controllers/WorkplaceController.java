package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.WorkplaceService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplaceController {

    private WorkplaceService workplaceService;
    @Autowired
    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Workplace>> getAll(){
        return workplaceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Workplace workplace){
        return workplaceService.add(workplace);
    }

}






