package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.LinkTypeService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linkTypes")
public class LinkTypeController {

    private LinkTypeService linkTypeService;
    @Autowired
    public LinkTypeController(LinkTypeService linkTypeService) {
        this.linkTypeService = linkTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<LinkType>> getAll(){
        return linkTypeService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody LinkType linkType){
        return linkTypeService.add(linkType);
    }

}


