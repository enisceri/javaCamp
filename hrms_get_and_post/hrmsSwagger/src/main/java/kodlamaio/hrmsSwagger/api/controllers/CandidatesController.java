package kodlamaio.hrmsSwagger.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsSwagger.business.abstracts.CandidateService;
import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;
import kodlamaio.hrmsSwagger.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll()
	{
		return this.candidateService.getAll();
	}
		
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate)
	{
		return this.candidateService.add(candidate);
	}
	

	
}
