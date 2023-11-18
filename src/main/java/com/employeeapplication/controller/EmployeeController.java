package com.employeeapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapplication.model.Employee;
import com.employeeapplication.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveemployeedetails")
	public Employee saveEmployeeDetails(@RequestBody Employee employee1) {
		try {
			employeeService.saveStudent(employee1);
		}catch(Exception e) {
			System.out.println(e);
		}
		return employee1;
	}
	
	@GetMapping("/test")
	public String getRequestParam(@RequestParam int id,String name) {
		return name+" id number is "+id;
	}
	
	
	
	
	@GetMapping("/getemployeedetails")
	public List<Employee> getEmployeeDetails(){
		return employeeService.getEmployeeDetails();
	}
	
	@GetMapping("/getemployeedetailsbyid/{id}")
	public Employee getEmployeeDetailsById(@PathVariable ("id") Long id){
		return employeeService.getEmployeeDetailsById(id);
	}
	
	@GetMapping("/getemployeedetailsbyname/{name}")
	public List<Employee> getEmployeeDetailsByName(@PathVariable ("name") String name){
		return employeeService.getEmployeeDetailsByName(name);
	}
	
	@GetMapping("/getemployeedetailsbysalary/{salary}")
	public List<Employee> getEmployeeBySalary(@PathVariable ("salary") double salary){
		return employeeService.getEmployeeBySalary(salary);
	}
	
	@GetMapping("getemployeebynameanddept/{name}/{dept}")
	public List<Employee> getEmployeeByNameAndDept(@PathVariable ("name") String name,@PathVariable ("dept") String dept){
		return employeeService.getEmployeeByNameAndDept(name,dept);
	}
}
