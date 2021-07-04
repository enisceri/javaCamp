package kodlamaio.hrmsSwagger.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsSwagger.business.abstracts.UserService;
import kodlamaio.hrmsSwagger.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll()
	{
		return this.userService.getAll();
	}

}
