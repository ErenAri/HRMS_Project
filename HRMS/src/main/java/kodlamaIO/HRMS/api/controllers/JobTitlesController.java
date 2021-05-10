package kodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.HRMS.business.abstracts.JobTitleService;
import kodlamaIO.HRMS.entities.concretes.JobTitle;

@RestController
@RequestMapping("api/job-titles/")
public class JobTitlesController {
	private final JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getAll")
	public List<JobTitle> getAll(){
		return this.jobTitleService.getAll();
	}
}
