package sb.crudtest.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sb.crudtest.one.model.Earning;
import sb.crudtest.one.model.Loan;

public interface EarningRepository extends JpaRepository<Earning, Long>{
	@Query(value = "select * from earning where id = ?1", nativeQuery = true)
    public List<Earning> earningIdSearch(long id);
}
