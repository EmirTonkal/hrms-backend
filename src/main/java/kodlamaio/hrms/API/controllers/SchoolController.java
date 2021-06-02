package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.SchoolService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.JobTitle;
import kodlamaio.hrms.Entities.Concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getall")
    public DataResult<List<School>> getAll(){
        return this.schoolService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school){
        return this.schoolService.add(school);
    }


}
