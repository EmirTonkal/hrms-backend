package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.Ability;
import kodlamaio.hrms.Entities.Concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
}
