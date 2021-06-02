package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.School;
import kodlamaio.hrms.Entities.Concretes.WorkplaceCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceCandidateDao extends JpaRepository<WorkplaceCandidate, Integer> {
}
