package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.School;
import kodlamaio.hrms.Entities.Concretes.SchoolCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolCandidateDao extends JpaRepository<SchoolCandidate, Integer> {
}
