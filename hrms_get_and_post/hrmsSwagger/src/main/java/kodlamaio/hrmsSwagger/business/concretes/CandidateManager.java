package kodlamaio.hrmsSwagger.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsSwagger.business.abstracts.CandidateService;
import kodlamaio.hrmsSwagger.core.utilities.results.DataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.ErrorResult;
import kodlamaio.hrmsSwagger.core.utilities.results.Result;
import kodlamaio.hrmsSwagger.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsSwagger.core.utilities.results.SuccessResult;
import kodlamaio.hrmsSwagger.dataAccess.abstracts.CandidateRepository;
import kodlamaio.hrmsSwagger.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	private CandidateRepository candidateRepository;
	
	public CandidateManager(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateRepository.findAll(),"Adaylar Listelendi");
		
	}


	
	@Override
	public DataResult<Candidate> getByEmail(String email) {

		return new SuccessDataResult<Candidate>
		(this.candidateRepository.findByEmail(email), "Aday emaile gore listelendi");

	}
	

	@Override
	public DataResult<Candidate> getByNatId(String natId) {

		return new SuccessDataResult<Candidate>
		(this.candidateRepository.findByNatId(natId), "Aday TCKN'ye gore listelendi");
	}
	



	@Override
	public Result add(Candidate candidate) {
		if(getByEmail(candidate.getEmail()).getData()  != null)
		{
			return new ErrorResult("Bu mail zaten alinmis !");
		}
		
		if(getByNatId(candidate.getNatId()).getData() != null)
		{
			return new ErrorResult("TC Kimlik numarasi sistemde zaten kayitli.");
		}
		
		this.candidateRepository.save(candidate);
		return new SuccessResult("Yeni kullanici sisteme eklendi");

	}

	

	

}
