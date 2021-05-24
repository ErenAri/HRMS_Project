package kodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.HRMS.business.abstracts.EmployerUserService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entities.concretes.EmployerUser;

@RestController
@RequestMapping("/api/employerusers")
public class EmployerUserController {
	
	private final EmployerUserService employerUserService;
	
	public EmployerUserController(EmployerUserService employerUserService) {
		this.employerUserService = employerUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerUser>> getAll(){
		return this.employerUserService.getAll();
	}
	
	@PostMapping("/findbyemailis")
	public DataResult<List<EmployerUser>> findByEmailIs(@RequestBody String email){
		return this.employerUserService.findByEmailIs(email.toLowerCase().trim());
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUser employerUser) {
		return this.employerUserService.add(employerUser);
	}

}
