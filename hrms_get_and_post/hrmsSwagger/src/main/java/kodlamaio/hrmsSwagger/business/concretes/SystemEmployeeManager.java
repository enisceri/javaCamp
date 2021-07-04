package kodlamaio.hrmsSwagger.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsSwagger.business.abstracts.SystemEmployeeService;
import kodlamaio.hrmsSwagger.dataAccess.abstracts.SystemEmployeeRepository;
import kodlamaio.hrmsSwagger.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService{
	private SystemEmployeeRepository systemEmployeeRepository;
	
	public SystemEmployeeManager(SystemEmployeeRepository systemEmployeeRepository) {
		this.systemEmployeeRepository = systemEmployeeRepository;
	}
	
	@Override
	public List<SystemEmployee> getAll() {

		return this.systemEmployeeRepository.findAll();
	}

}
