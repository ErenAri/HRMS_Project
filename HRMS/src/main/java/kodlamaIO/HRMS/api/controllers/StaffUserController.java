package kodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.HRMS.business.abstracts.StaffUserService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.entities.concretes.StaffUser;

@RestController
@RequestMapping("/api/staffusers")
public class StaffUserController {
	
	private final StaffUserService staffUserService;
	
	@Autowired
	public StaffUserController(StaffUserService staffUserService) {
		this.staffUserService = staffUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<StaffUser>> getAll(){
		return this.staffUserService.getAll();
	}
}
