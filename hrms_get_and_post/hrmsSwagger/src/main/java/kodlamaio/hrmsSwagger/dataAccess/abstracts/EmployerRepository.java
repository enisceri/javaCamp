package kodlamaio.hrmsSwagger.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsSwagger.entities.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{
	Employer findByEmail(String email);

}
