package kodlamaio.hrmsSwagger.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsSwagger.business.abstracts.EmployerService;
import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.ErrorResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;
import kodlamaio.hrmsSwagger.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.SuccessResult;
import kodlamaio.hrmsSwagger.dataAccess.abstracts.EmployerRepository;
import kodlamaio.hrmsSwagger.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerRepository employerRepository;
	
	public EmployerManager(EmployerRepository employerRepository) {
		this.employerRepository = employerRepository;
	}
	@Override
	public List<Employer> getAll() {

		return this.employerRepository.findAll();
	}
	@Override
	public DataResult<Employer> getByEmail(String email) {

		return new SuccessDataResult<Employer>
		(this.employerRepository.findByEmail(email), "Aday emaile gore listelendi");

	}
	
	@Override
	public Result add(Employer employer) {
		if(getByEmail(employer.getEmail()).getData()  != null)
		{
			return new ErrorResult("Bu mail zaten alinmis !");
		}
		
		
		
		this.employerRepository.save(employer);
		return new SuccessResult("Yeni is veren sisteme eklendi");

	}

}
