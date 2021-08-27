package sb.crudtest.one.service;
import java.util.List;

import sb.crudtest.one.model.Earning;
import sb.crudtest.one.model.Employee;
import sb.crudtest.one.model.Loan;



public interface EmployeeService {
	List<Employee> getAllEmployees();
	List<Loan> getAllLoan();
	List<Earning> getAllEarning();
	Loan getLoanByID(long id);
	Earning getEarningById(long id);
	void saveEmployee(Employee employee);
	Employee getEmployeeByID(long id);
	void deleteEmployeeByID(long id);
}
