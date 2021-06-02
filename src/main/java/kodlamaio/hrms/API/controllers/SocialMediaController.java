package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.SocialMediaService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SocialMedias")
public class SocialMediaController {

    private SocialMediaService socialMediaService;
    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SocialMedia>> getAll(){
        return socialMediaService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SocialMedia socialMedia){
       return socialMediaService.add(socialMedia);
    }
}


