package com.employeeapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapplication.model.Employee;
import com.employeeapplication.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeerepo;

	public void saveStudent(Employee employee1) {
		employeerepo.save(employee1);
		
	}

	public List<Employee> getEmployeeDetails() {
		// TODO Auto-generated method stub
		List<Employee> employeeList=employeerepo.findAll();
		return employeeList;
		
	}

	public Employee getEmployeeDetailsById(Long id) {
		Optional<Employee> o=employeerepo.findById(id);
		if(o.isPresent()) {
			return o.get();			
		}
		else {
			return null;
		}
	}

	public List<Employee> getEmployeeDetailsByName(String name) {
		
		return employeerepo.findByename(name);
	}

	public List<Employee> getEmployeeBySalary(double salary) {
		
		return employeerepo.findByesalary(salary);
	}

	public List<Employee> getEmployeeByNameAndDept(String name, String dept) {
		return employeerepo.findByNameAndDept(name,dept);
	}

}
