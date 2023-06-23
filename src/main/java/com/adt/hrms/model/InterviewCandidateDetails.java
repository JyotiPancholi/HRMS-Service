package com.adt.hrms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "CandidateDetails")
public class InterviewCandidateDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Integer candidateId;

	@Column(name = "candidate_name")
	private String candidateName;

	@Column(name = "email_id")
	@Email
	private String emailId;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "address")
	private String address;

	@Column(name = "highest_qualification")
	private String highestQualification;

	@Column(name = "work_experience")
	private String workExperience;

	@Column(name = "technical_stack")
	private String technicalStack;

	@Column(name = "cv_shortlisted")
	private boolean cvShortlisted;

	@Column(name = "last_ctc")
	private double lastCTC;

	@Column(name = "notice_period")
	private Integer noticePeriod;
	
	@Column(name = "dob")
	private LocalDate dob;
}
