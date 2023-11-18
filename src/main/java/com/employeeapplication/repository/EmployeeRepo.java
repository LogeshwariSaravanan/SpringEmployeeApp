package com.employeeapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapplication.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	List<Employee> findByename(String name);

	List<Employee> findByesalary(double salary);

	@Query("select e from Employee e where ename=?1 and edept=?2")
	List<Employee> findByNameAndDept(String name, String dept);

}
