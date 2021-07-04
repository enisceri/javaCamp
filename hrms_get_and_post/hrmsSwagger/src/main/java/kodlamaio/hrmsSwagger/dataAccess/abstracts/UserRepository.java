package kodlamaio.hrmsSwagger.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsSwagger.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
