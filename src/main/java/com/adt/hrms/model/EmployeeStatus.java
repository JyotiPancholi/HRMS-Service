package com.adt.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "Employeestatus")
public class EmployeeStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EmpId")
	private Integer empId;
	@Column(name = "ManagerId")
	private Integer managerId;
	@Column(name = "ProjectId")
	private String projectId;
	@Column(name = "EmployeeStatus")
	private String empStatus;
	@Column(name = "EmploymentType")
	private String employmentType;

}
