package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.AbilityCandidateService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.AbilityCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilityCandidates")
public class AbilityCandidateController {

    private AbilityCandidateService abilityCandidateService;
    @Autowired
    public AbilityCandidateController(AbilityCandidateService abilityCandidateService) {
        this.abilityCandidateService = abilityCandidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<AbilityCandidate>> getAll(){
        return abilityCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AbilityCandidate abilityCandidate){
        return abilityCandidateService.add(abilityCandidate);
    }


}
