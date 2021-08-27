package sb.crudtest.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sb.crudtest.one.model.Employee;
import sb.crudtest.one.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	@Query(value = "select * from loan where id = ?1", nativeQuery = true)
    public List<Loan> loanIdSearch(long id);

}
