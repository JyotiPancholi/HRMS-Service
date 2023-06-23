package com.adt.hrms.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(catalog = "EmployeeDB", schema = "user_schema", name = "_EMPLOYEE")
@Proxy(lazy = false)
@Data
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", allocationSize = 1)
	private int employeeId;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "designation")
	private String designation;

	@Column(name = "DOB")
	private String dob;

	@NaturalId
	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "IS_EMAIL_VERIFIED", nullable = false)
	private Boolean isEmailVerified;

	@Column(name = "JoiningDate")
	private String joinDate;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "maritalStatus")
	private String maritalStatus;

	@Column(name = "MobileNo")
	private Long mobileNo;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "ifsc_code")
	private String ifscCode;
	
	//Jira no :- HRMS-77 start--
	@Lob
	@Column(name = "resume", length = 1000)
	private byte[] resume;
	//Jira no :- HRMS-77 End--
	
	//jira no-HRMS-78 ---- START
	@Lob
	@Column(name="aadhar_card", length=1000)
	private byte[] aadharCard;
		
	@Lob
	@Column(name="pan_card", length =1000)
	private byte[] panCard;
	//jira no-HRMS-78 ---- END
}
