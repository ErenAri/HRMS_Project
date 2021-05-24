package kodlamaIO.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaIO.HRMS.entities.concretes.StaffUser;

@Repository
public interface StaffUserDao extends JpaRepository<StaffUser, Integer>{
	List<StaffUser> findByFirstNameIs(String firstName);
	List<StaffUser> findByLastNameIs(String lastName);

}
