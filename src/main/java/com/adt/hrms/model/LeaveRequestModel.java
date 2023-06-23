package com.adt.hrms.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "LeaveRequest")
public class LeaveRequestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leaveid", columnDefinition = "serial")
	private Integer leaveid;

	@Column(name = "empid")
	private Integer empid;

	@Column(name = "status")
	private String status;

	@ElementCollection
	@CollectionTable(catalog = "EmployeeDB", schema = "employee_schema", name = "LEAVE_DATES", joinColumns = @JoinColumn(name = "LEAVE_ID"))
	@Column(name = "leavedate")
	private List<String> leavedate;

}
