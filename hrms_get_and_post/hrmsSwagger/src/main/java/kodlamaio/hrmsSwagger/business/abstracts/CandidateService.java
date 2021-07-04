package kodlamaio.hrmsSwagger.business.abstracts;

import java.util.List;


import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;
import kodlamaio.hrmsSwagger.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getByEmail(String email);
	DataResult<Candidate> getByNatId(String natId);
	Result add(Candidate candidate);




}
