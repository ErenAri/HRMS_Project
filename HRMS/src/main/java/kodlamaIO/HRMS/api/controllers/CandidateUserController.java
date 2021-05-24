package kodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.HRMS.business.abstracts.CandidateUserService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entities.concretes.CandidateUser;

@RestController
@RequestMapping("/api/candidateusers")
public class CandidateUserController {
	private final CandidateUserService candidateUserService;
	
	@Autowired
	public CandidateUserController(CandidateUserService candidateUserService) {
		this.candidateUserService = candidateUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateUser>> getAll(){
		return this.candidateUserService.getAll();
	}
	
	@PostMapping("/findbyemailis")
	public DataResult<List<CandidateUser>> findByEmailIs(@RequestBody String email){
		return this.candidateUserService.findByEmailIs(email.toLowerCase().trim());
	}
	
	@PostMapping("/findbyidentitynumberis")
	public DataResult<List<CandidateUser>> findIdentityNumberIs(@RequestBody String identityNumber){
		return this.candidateUserService.findByIdentityNumberIs(identityNumber.trim());
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateUser candidateUser) {
		return this.candidateUserService.add(candidateUser);
	}

}
