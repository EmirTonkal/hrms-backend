package kodlamaio.hrms.API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.Business.Abstracts.JobAdvertisementService;
import kodlamaio.hrms.Core.utilities.results.DataResult;
import kodlamaio.hrms.Core.utilities.results.Result;
import kodlamaio.hrms.Entities.Concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class jobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public jobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>>  getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue(){
		return this.jobAdvertisementService.getAllByIsActiveTrue();
	}
	
	@GetMapping("/getByisActiveTrueOrderByApplicationDeadlineAsc")
	public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadlineAsc(){
		return this.jobAdvertisementService.getByisActiveTrueOrderByApplicationDeadlineAsc();
	}
	
	@GetMapping("/getByisActiveTrueAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployerId(int id){
		return this.jobAdvertisementService.getByisActiveTrueAndEmployerId(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PutMapping("/update")
	public Result update(@RequestParam int id, @RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.update(id , jobAdvertisement);
	}
	

	
}
