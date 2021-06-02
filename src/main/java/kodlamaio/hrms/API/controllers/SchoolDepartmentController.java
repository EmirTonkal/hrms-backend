package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.SchoolDepartmentService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schoolDepartment")
public class SchoolDepartmentController {

    private SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolDepartment>> getAll(){
        return this.schoolDepartmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.add(schoolDepartment);
    }


}