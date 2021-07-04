package kodlamaio.hrmsSwagger.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsSwagger.entities.concretes.Job;


public interface JobRepository extends JpaRepository<Job, Integer>{
	Job findByName(String jobName);
	
    

}
