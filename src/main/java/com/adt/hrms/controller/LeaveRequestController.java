package com.adt.hrms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adt.hrms.model.LeaveRequestModel;
import com.adt.hrms.service.LeaveRequestService;

@RestController
@RequestMapping("/leave")
public class LeaveRequestController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LeaveRequestService leaveRequestService;

	@PostMapping("/leaveRequest")
	public ResponseEntity<String> saveLeaveRequest(@RequestBody LeaveRequestModel lr) {
		LOGGER.info("Employeeservice:leave:saveLeaveRequest info level log message");
		return new ResponseEntity<>(leaveRequestService.saveLeaveRequest(lr), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getLeaveDetails")
	public ResponseEntity<List<LeaveRequestModel>> getLeaveDetails() {
		LOGGER.info("Employeeservice:leave:getLeaveDetails info level log message");
		return new ResponseEntity<>(leaveRequestService.getLeaveDetails(), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_USER',T(java.util.Map).of('currentUser', #empId))")
	@GetMapping("getAllLeaveByEmpId/{empId}")
	public ResponseEntity<List<LeaveRequestModel>> getLeaveRequestDetailsByEmpId(@PathVariable("empId") int empId) {
		LOGGER.info("Employeeservice:leave:getLeaveRequestDetailsByEmpId info level log message");
		return new ResponseEntity<>(leaveRequestService.getLeaveRequestDetailsByEmpId(empId), HttpStatus.OK);
	}

}
