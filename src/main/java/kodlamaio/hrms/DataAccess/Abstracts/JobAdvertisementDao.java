package kodlamaio.hrms.DataAccess.Abstracts;

import java.util.List;

import kodlamaio.hrms.Entities.dtos.JobAdvertisementDetailsDtos;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByisActiveTrue();
	
	List<JobAdvertisement> getByisActiveTrueOrderByApplicationDeadlineAsc();
	
	List<JobAdvertisement> getByisActiveTrueAndEmployer_Id(int id);

	@Query("select new kodlamaio.hrms.Entities.dtos.JobAdvertisementDetailsDtos(e.companyName,t.title,j.quota, c.cityName,j.applicationDeadline,j.createdDate) " +
			"from JobAdvertisement j inner join j.employer e inner join j.jobTitle t inner join j.city c")
	List<JobAdvertisementDetailsDtos> getAdvertisementWithEmployerDetails();
}


