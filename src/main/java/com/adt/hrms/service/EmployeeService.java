package com.adt.hrms.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.adt.hrms.model.Employee;
import com.adt.hrms.model.EmployeeStatus;

public interface EmployeeService {

	public List<Employee> getAllEmps();

	public Employee getEmp(Integer empId);

	public String saveEmp(Employee emp);

	public String deleteEmpById(Integer empId);

//	public String updateEmp(Integer empId, Employee emp,MultipartFile resume);
	
	//Jira no :- HRMS-77 START--
	//Jira no :- HRMS-78 START--
	public String updateEmp(Employee emp,MultipartFile resume,MultipartFile aadhar,MultipartFile pan)throws IOException ;
	//Jira no :- HRMS-77 END--
	//Jira no :- HRMS-78 END--

	//Jira no :- HRMS-82 start--
	public byte[] downloadImage(int id);
	//Jira no :- HRMS-82 End--
	
	public EmployeeStatus getEmployeeById(Integer empId);

	public Employee getEmployeeById(int empId);

	List<Employee> SearchEmployee(String query);

	List<Employee> SearchByEmailId(String query);


}
