package kodlamaio.hrmsSwagger.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsSwagger.entities.concretes.SystemEmployee;

public interface SystemEmployeeRepository extends JpaRepository<SystemEmployee, Integer>{

}
