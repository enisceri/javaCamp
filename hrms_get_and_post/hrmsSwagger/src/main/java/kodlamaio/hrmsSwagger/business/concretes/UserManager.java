package kodlamaio.hrmsSwagger.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsSwagger.business.abstracts.UserService;
import kodlamaio.hrmsSwagger.dataAccess.abstracts.UserRepository;
import kodlamaio.hrmsSwagger.entities.concretes.User;

@Service
public class UserManager implements UserService{
	private UserRepository userRepository;
	
	public UserManager() {
		
	}
	
	@Autowired
	public UserManager(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	

	@Override
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

}
