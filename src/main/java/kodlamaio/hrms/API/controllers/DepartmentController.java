package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.DepartmentService;
import kodlamaio.hrms.Business.Abstracts.SchoolService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Department;
import kodlamaio.hrms.Entities.Concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll(){
        return this.departmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department){
        return this.departmentService.add(department);
    }
}