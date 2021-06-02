package kodlamaio.hrms.API.controllers;

import kodlamaio.hrms.Business.Abstracts.LanguageLevelService;
import kodlamaio.hrms.Business.Abstracts.LanguageService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.Language;
import kodlamaio.hrms.Entities.Concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languageLevels")
public class LanguageLevelController {

    private LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelController(LanguageLevelService languageLevelService) {
        this.languageLevelService = languageLevelService;
    }

    @GetMapping("/getall")
    public DataResult<List<LanguageLevel>> getAll() {
        return languageLevelService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageLevel languageLevel) {
        return languageLevelService.add(languageLevel);
    }
}