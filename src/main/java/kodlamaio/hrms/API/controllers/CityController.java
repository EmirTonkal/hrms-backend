package kodlamaio.hrms.API.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Business.Abstracts.CityService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Entities.Concretes.City;


@RestController
@RequestMapping("/api/cities")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	


	@GetMapping("/getall")
	public DataResult<List<City>>  getAll(){
	return this.cityService.getAll();
	}
}
