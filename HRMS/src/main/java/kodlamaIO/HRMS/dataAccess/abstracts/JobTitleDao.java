package kodlamaIO.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaIO.HRMS.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	List<JobTitle> findByIdIs(int id);
	List<JobTitle> findByTitleIs(String title);
}
