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
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "InterviewRounds")
public class InterviewRounds {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "interviewId")
	private Integer interviewId;

	@Column(name = "interviewName")
	private String interviewerName;

	@Column(name = "notes")
	private String notes;

	@Column(name = "passable")
	private boolean passable;

}
