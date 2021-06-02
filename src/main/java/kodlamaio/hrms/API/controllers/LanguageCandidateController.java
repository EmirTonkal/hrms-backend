package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.LanguageCandidateService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.LanguageCandiate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languageCandidates")
public class LanguageCandidateController {

    private LanguageCandidateService languageCandidateService;
    @Autowired
    public LanguageCandidateController(LanguageCandidateService languageCandidateService) {
        this.languageCandidateService = languageCandidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<LanguageCandiate>> getAll(){
        return languageCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageCandiate languageCandiate){
        return languageCandidateService.add(languageCandiate);
    }
}
