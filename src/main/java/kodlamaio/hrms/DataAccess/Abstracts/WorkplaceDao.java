package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer> {
}
