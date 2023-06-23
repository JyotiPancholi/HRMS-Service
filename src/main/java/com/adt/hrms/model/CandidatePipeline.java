package com.adt.hrms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "CandidatePipeline")
public class CandidatePipeline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "interview_id")
	private Integer interviewId;

	@Column(name = "offer_release_date")
	private LocalDateTime offerReleaseDate;

	@Column(name = "last_communication_date")
	private LocalDateTime lastCommunicationDate;

	@Column(name = "target_onboarding_date")
	private LocalDateTime targetOnboardingDate;

}
