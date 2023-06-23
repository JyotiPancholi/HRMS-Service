package com.adt.hrms.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adt.hrms.model.Employee;
import com.adt.hrms.model.EmployeeStatus;
import com.adt.hrms.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeService employeeService;

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getById/{empId}")
	public ResponseEntity<Employee> getEmp(@PathVariable("empId") int empId) {
		LOGGER.info("Employeeservice:employee:getEmp info level log message");
		return new ResponseEntity<>(employeeService.getEmp(empId), HttpStatus.OK);
	}

	@PostMapping("/addEmp")
	public ResponseEntity<String> saveEmp(@RequestBody Employee emp) {
		LOGGER.info("Employeeservice:employee:saveEmp info level log message");
		return new ResponseEntity<>(employeeService.saveEmp(emp), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmps() {
		LOGGER.info("Employeeservice:employee:getAllEmps info level log message");
		return new ResponseEntity<>(employeeService.getAllEmps(), HttpStatus.OK);
	}
	//Jira no :- HRMS-77 START--
	//Jira no :- HRMS-78 START--
	@PreAuthorize("@auth.allow('ROLE_ADMIN') or @auth.allow('ROLE_USER',T(java.util.Map).of('currentUser', #empId))")
	@PutMapping("/updateEmp")
	public ResponseEntity<String> updateEmp(@RequestPart("file") MultipartFile resume, @RequestPart String emp,
			@RequestPart("image") MultipartFile aadhar,@RequestPart("image1") MultipartFile pan) throws IOException {
		LOGGER.info("Employeeservice:employee:updateEmp info level log message");
		ObjectMapper mapper=new ObjectMapper();
		Employee e=mapper.readValue(emp,Employee.class);
		return new ResponseEntity<>(employeeService.updateEmp(e,resume,aadhar,pan), HttpStatus.OK);
	}
	//Jira no :- HRMS-77 END--
	//Jira no :- HRMS-78 END--
	
	//Jira no :- HRMS-82 start--
	@GetMapping("downloadResume/{id}")
	public ResponseEntity<?> downloadImage(@PathVariable int id){
		byte[] imageData=employeeService.downloadImage(id);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}
	//Jira no :- HRMS-82 End--
	
	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmp(@PathVariable("empId") int empId) {
		LOGGER.info("Employeeservice:employee:deleteEmp info level log message");
		return new ResponseEntity<String>(employeeService.deleteEmpById(empId), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/findStatusById/{empId}")
	public ResponseEntity<EmployeeStatus> findEmployeeByEmployeeId(@PathVariable("empId") Integer empId) {
		LOGGER.info("Employeeservice:employee:findEmployeeByEmployeeId info level log message");
		return new ResponseEntity<EmployeeStatus>(employeeService.getEmployeeById(empId), HttpStatus.OK);

	}

	@GetMapping("/searchByFirstLastname")
	public ResponseEntity<List<Employee>> SearchEmployee(@RequestParam("query") String query) {
		LOGGER.info("Employeeservice:employee:SearchEmployeeByFirstLastName info level log message");
		return ResponseEntity.ok(employeeService.SearchEmployee(query));
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/emailId")
	public ResponseEntity<List<Employee>> SearchByEmailId(@RequestParam("query") String query) {
		LOGGER.info("Employeeservice:employee:SearchByEmailId info level log message");
		return ResponseEntity.ok(employeeService.SearchByEmailId(query));
	}

}
