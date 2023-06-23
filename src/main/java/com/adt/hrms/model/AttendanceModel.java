package com.adt.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema",name = "Attendance")
public class AttendanceModel {
	
	@Id
	@Column(name = "attendanceId")
	 private Integer attendanceId;
	
	@Column(name = "checkOut")
	    private String checkOut;
	@Column(name = "checkIn")
	    private String checkIn;
	@Column(name = "workingHour")
	    private String workingHour;
	@Column(name = "date")
	    private String date;

}
