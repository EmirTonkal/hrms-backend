package kodlamaio.hrms.DataAccess.Abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.Entities.Concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

	List<JobTitle> findAllByTitle(String title);
	
}
