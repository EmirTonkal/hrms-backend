package kodlamaio.hrms.API.controllers;


import kodlamaio.hrms.Business.Abstracts.WorkplaceCandidateService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplaceCandidates")
public class WorkplaceCandidateController {

    private WorkplaceCandidateService workplaceCandidateService;
    @Autowired
    public WorkplaceCandidateController(WorkplaceCandidateService workplaceCandidateService) {
        this.workplaceCandidateService = workplaceCandidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkplaceCandidate>> getAll(){
        return workplaceCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkplaceCandidate workplaceCandidate){
        return workplaceCandidateService.add(workplaceCandidate);
    }
}


