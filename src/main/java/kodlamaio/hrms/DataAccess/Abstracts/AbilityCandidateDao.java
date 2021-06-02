package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.Ability;
import kodlamaio.hrms.Entities.Concretes.AbilityCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityCandidateDao extends JpaRepository<AbilityCandidate, Integer> {
}
