package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.SchoolCandidateService;
import kodlamaio.hrms.Business.Abstracts.SchoolService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.School;
import kodlamaio.hrms.Entities.Concretes.SchoolCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schoolCandidates")
public class SchoolCandidateController {

    private SchoolCandidateService schoolCandidateService;

    @Autowired
    public SchoolCandidateController(SchoolCandidateService schoolCandidateService) {
        this.schoolCandidateService = schoolCandidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolCandidate>> getAll(){
        return this.schoolCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolCandidate schoolCandidate){
        return this.schoolCandidateService.add(schoolCandidate);
    }


}