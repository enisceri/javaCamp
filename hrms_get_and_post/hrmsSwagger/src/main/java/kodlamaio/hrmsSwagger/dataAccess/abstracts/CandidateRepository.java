package kodlamaio.hrmsSwagger.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsSwagger.entities.concretes.Candidate;


public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	Candidate findByEmail(String email);
	Candidate findByNatId(String natId);

}
