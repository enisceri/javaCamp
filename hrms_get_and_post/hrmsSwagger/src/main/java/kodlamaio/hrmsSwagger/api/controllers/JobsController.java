package kodlamaio.hrmsSwagger.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsSwagger.business.abstracts.JobService;
import kodlamaio.hrmsSwagger.entities.concretes.Job;
import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Job>> getAll()
	{
		return this.jobService.getAll();
	}
	

	
	@PostMapping("/add")
	public Result add(@RequestBody Job job)
	{
		return this.jobService.add(job);
	}
	

	
	

}
