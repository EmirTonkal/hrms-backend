package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.LanguageService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
       return languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language){
        return languageService.add(language);
    }
}
