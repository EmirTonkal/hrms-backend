package kodlamaio.hrms.Entities.Concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name="employees")
public class Employee extends User {

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
}
