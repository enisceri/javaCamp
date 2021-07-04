package kodlamaio.hrmsSwagger.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsSwagger.business.abstracts.JobService;
import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.ErrorResult;
import kodlamaio.hrmsSwagger.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.SuccessResult;
import kodlamaio.hrmsSwagger.dataAccess.abstracts.JobRepository;
import kodlamaio.hrmsSwagger.entities.concretes.Job;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;

@Service
public class JobManager implements JobService{
	
	private JobRepository jobRepository;
	
	public JobManager() {
	
	}
	
	@Autowired
	public JobManager(JobRepository jobRepository)
	{
		this.jobRepository = jobRepository;
	}
	
	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>
		(this.jobRepository.findAll(),"Meslekler Listelendi");
	
	}
	
	@Override
	public Result add(Job job) {
		if(getByJobName(job.getName())  != null)
		{
			return new ErrorResult("Eklenmek istenen meslek kayitta zaten mevcut");
		}
		
		this.jobRepository.save(job);
		return new SuccessResult("Yeni meslek eklendi");
		
	}

	@Override
	public Job getByJobName(String jobName) {
		return this.jobRepository.findByName(jobName);
	
	}



	
}
