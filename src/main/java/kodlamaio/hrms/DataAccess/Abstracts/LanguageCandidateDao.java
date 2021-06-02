package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.Language;
import kodlamaio.hrms.Entities.Concretes.LanguageCandiate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageCandidateDao extends JpaRepository<LanguageCandiate, Integer> {
}
