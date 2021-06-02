package kodlamaio.hrms.DataAccess.Abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	List<Employer> findAllByEmail(String email);
	
	boolean existsById(int id);
}
