package kodlamaio.hrms.DataAccess.Abstracts;


import kodlamaio.hrms.Entities.Concretes.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer> {
}
