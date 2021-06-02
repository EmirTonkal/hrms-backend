package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

	boolean existsById(int id);
	
}
