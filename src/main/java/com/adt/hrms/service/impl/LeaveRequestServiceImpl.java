package com.adt.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adt.hrms.model.LeaveRequestModel;
import com.adt.hrms.repository.LeaveRequestRepo;
import com.adt.hrms.service.LeaveRequestService;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	private LeaveRequestRepo leaveRequestRepo;

	@Autowired
	private EmailService emailService;

	@Override
	public String saveLeaveRequest(LeaveRequestModel lr) {

		Optional<LeaveRequestModel> opt = leaveRequestRepo.findById(lr.getLeaveid());
		lr.setStatus("Pending");
		if (opt.isPresent())
			return "Leave Id " + lr.getLeaveid() + " is already avalable Pls Insert new ID....";
		leaveRequestRepo.save(lr);
		emailService.sendEmail();
		return lr.getLeaveid() + " Leave Request is saved & mail Sent Successfully";

	}

	@Override
	public List<LeaveRequestModel> getLeaveDetails() {
		List<LeaveRequestModel> leavelist = leaveRequestRepo.findAll();
		return leavelist;
	}

	@Override
	public List<LeaveRequestModel> getLeaveRequestDetailsByEmpId(Integer empid) {
		List<LeaveRequestModel> opt = leaveRequestRepo.findByempid(empid);
		if (!opt.isEmpty()) {
			return opt;
		} else {
			return null;
		}
	}
}
