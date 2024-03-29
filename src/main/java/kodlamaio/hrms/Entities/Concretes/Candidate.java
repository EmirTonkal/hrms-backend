package kodlamaio.hrms.Entities.Concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.Entities.Abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler",
		"schoolCandidates","languageCandiates",
		"abilityCandidates","workplaceCandidates",
		"socialMedias"})
public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String  identificationNumber;
	
	@Column(name="birth_date")
	private Date birthDate;


	@JsonIgnore
	@OneToMany(mappedBy = "candidate" )
	private List<SchoolCandidate> schoolCandidates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate" )
	private List<LanguageCandiate> languageCandiates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate" )
	private List<AbilityCandidate> abilityCandidates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate" )
	private List<WorkplaceCandidate> workplaceCandidates;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate" )
	private List<SocialMedia> socialMedias;


}
