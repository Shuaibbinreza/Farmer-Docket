package sb.crudtest.one.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import sb.crudtest.one.model.Earning;
import sb.crudtest.one.model.Employee;
import sb.crudtest.one.model.Loan;
import sb.crudtest.one.repository.EarningRepository;
import sb.crudtest.one.repository.EmployeeRepository;
import sb.crudtest.one.repository.LoanRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM enployee WHERE ID=?";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private EarningRepository earningRepository;

//	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}
		else {
			throw new RuntimeException("Employee Not found for ID:: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeByID(long id) {
		this.employeeRepository.deleteById(id);
		
	}


	@Override
	public List<Loan> getAllLoan() {
		// TODO Auto-generated method stub
		return loanRepository.findAll();
	}


	public List<Employee> search(long keyword) {
		// TODO Auto-generated method stub
		return employeeRepository.search(keyword);
	}
	
	public List<Loan> show(long id) {
		// TODO Auto-generated method stub
		return loanRepository.loanIdSearch(id);
	}
	
	public List<Earning> eshow(long id) {
		// TODO Auto-generated method stub
		return earningRepository.earningIdSearch(id);
	}


	@Override
	public Loan getLoanByID(long id) {
		Optional<Loan> optional = loanRepository.findById(id);
		Loan loan = null;
		
		if(optional.isPresent()) {
			loan = optional.get();
		}
		else {
			throw new RuntimeException("Employee Not found for ID:: " + id);
		}
		return loan;
	}
	
	@Override
	public Earning getEarningById(long id) {
		Optional<Earning> optional = earningRepository.findById(id);
		Earning earning = null;
		
		if(optional.isPresent()) {
			earning = optional.get();
		}
		else {
			throw new RuntimeException("Employee Not found for ID:: " + id);
		}
		return earning;
	}


	@Override
	public List<Earning> getAllEarning() {
		// TODO Auto-generated method stub
		return earningRepository.findAll();
	}
	

}
