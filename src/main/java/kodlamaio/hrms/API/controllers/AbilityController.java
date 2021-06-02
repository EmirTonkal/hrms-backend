package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.AbilityService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilityController {

    private AbilityService abilityService;
    @Autowired
    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Ability>> getAll(){
        return abilityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Ability ability){
        return abilityService.add(ability);
    }


}
