package kodlamaio.hrmsSwagger.business.abstracts;

import java.util.List;

import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;
import kodlamaio.hrmsSwagger.entities.concretes.Job;



public interface JobService {
	DataResult<List<Job>> getAll();
	Job getByJobName(String jobName);
	Result add(Job job);
	

	



}
