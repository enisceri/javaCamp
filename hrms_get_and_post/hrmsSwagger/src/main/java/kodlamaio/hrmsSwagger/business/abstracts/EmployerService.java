package kodlamaio.hrmsSwagger.business.abstracts;

import java.util.List;

import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;
import kodlamaio.hrmsSwagger.entities.concretes.Employer;


public interface EmployerService{
	List<Employer> getAll();
	DataResult<Employer> getByEmail(String email);
	Result add(Employer employer);

}
