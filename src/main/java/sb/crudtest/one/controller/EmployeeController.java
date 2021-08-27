package sb.crudtest.one.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sb.crudtest.one.model.Earning;
import sb.crudtest.one.model.Employee;
import sb.crudtest.one.model.Loan;
import sb.crudtest.one.repository.LoanRepository;
import sb.crudtest.one.service.EmployeeService;
import sb.crudtest.one.service.EmployeeServiceImp;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private LoanRepository loanRepository;
	
	@Autowired
	private EmployeeServiceImp esi;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//Display all the employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@GetMapping("/teampage")
	public String teampage(Model model) {
		return "Team";
	}
	
	@GetMapping("/projectdescription")
	public String projectdescription(Model model) {
		
		return "Description";
	}
	
	@GetMapping("/loanpage")
	public String loanpage(Model model) {
		model.addAttribute("loansl", employeeService.getAllLoan());
		return "loans";
	}
	
	@GetMapping("/earningpage")
	public String earningpage(Model model) {
		model.addAttribute("revenueList", employeeService.getAllEarning());
		return "revenue";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showNewRevenueFrom")
	public String showNewRevenueFrom(Model model) {
		Earning earning = new Earning();
		model.addAttribute("earning", earning);
		return "new_revenue";
	}
	
	@PostMapping("/saveRevenue")
	public String saveRevenue(@ModelAttribute("earning") Earning earning) {
		//SAVE
		//employeeService.saveEmployee(employee);
		String add = "INSERT INTO `testdb`.`earning` (`year`, `id`, `revenue`, `tc`) VALUES (?,?,?,?)";

		int rows = jdbcTemplate.update(add, earning.getYear(),
				earning.getId(),
				earning.getRevenue(),
				earning.getTc());
		if(rows == 1) {
			return "redirect:/";
		}
		else {
			return "redirect:/";
		}
	} 
	
	@GetMapping("/showNewLoanForm")
	public String showNewLoanForm(Model model) {
		Loan loan = new Loan();
		model.addAttribute("loan", loan);
		return "new_loan";
	}
	
	@PostMapping("/saveLoan")
	public String saveLoan(@ModelAttribute("loan") Loan loan) {
		//SAVE
		//employeeService.saveEmployee(employee);
		String add = "INSERT INTO `testdb`.`loan` (vno, `id`, `amount`, `pay_take`) VALUES (?,?,?,?)";

		int rows = jdbcTemplate.update(add, loan.getVno(),
				loan.getId(),
				loan.getAmount(),
				loan.getPayortake());
		if(rows == 1) {
			return "redirect:/loanpage";
		}
		else {
			return "redirect:/";
		}
	} 
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate (@PathVariable (value = "id") long id, Model model) {
		//Get Employee form the service
		Employee employee = employeeService.getEmployeeByID(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/showDetails/{id}")
	public String showDetails (@PathVariable (value = "id") long id, Model model) {
		//Get Employee form the service
		Employee employee = employeeService.getEmployeeByID(id);
		//Loan loan = employeeService.getLoanByID(id);
		model.addAttribute("employee", employee);	
		List <Loan> loanid = esi.show(id);
		model.addAttribute("loanid", loanid);
		
		List<Earning> esid = esi.eshow(id);
		model.addAttribute("esid", esid);
		return "full_details";
	}
		
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id, Model model) {
		//Delete
		
		this.employeeService.deleteEmployeeByID(id);
		return "redirect:/";		
	}	
	
	@GetMapping("/search")
	public String search(@Param("keyword") long keyword, Model model) {
		System.out.println("Keyword: " + keyword);
		
		List<Employee> searchResult = esi.search(keyword);
		List<Loan> loanid = esi.show(keyword);
		//model.addAttribute("keyword", keyword);
		//model.addAttribute("pageTitle", "Search result for: " + keyword);
		model.addAttribute("searchResult", searchResult);
		model.addAttribute("loanid", loanid);
		
		return "search_result";
	}	
	
}
