package com.adt.hrms.service;

import java.util.List;

import com.adt.hrms.model.LeaveRequestModel;

public interface LeaveRequestService {

	public String saveLeaveRequest(LeaveRequestModel lr);

	public List<LeaveRequestModel> getLeaveDetails();

	public List<LeaveRequestModel> getLeaveRequestDetailsByEmpId(Integer empid);

}
