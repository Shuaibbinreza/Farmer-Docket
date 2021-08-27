package sb.crudtest.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sb.crudtest.one.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value = "select * from employee where id = ?1", nativeQuery = true)
	public List<Employee> search(long keyword);
	
}
