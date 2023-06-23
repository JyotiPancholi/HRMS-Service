package com.adt.hrms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.adt.hrms.ui.InterviewIdRound;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(InterviewIdRound.class)
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "interview")
@NoArgsConstructor
public class Interview {

	// PK
	@Id
	@Column(name = "interview_id")
	private Integer interviewId;

	// PK
	@Id
	@Column(name = "Rounds")
	private Integer rounds;

	// FK
	@OneToOne
	@JoinColumn(name = "candidate_id")
	private InterviewCandidateDetails candidate_id;

	// FK
	@OneToOne
	@JoinColumn(name = "tech_id")
	private AVTechnology tech_id;

	// FK
	@OneToOne
	@JoinColumn(name = "position_id")
	private PositionModel position_id;

	@Column(name = "Marks")
	private Integer marks;

	@Column(name = "Communication")
	private Integer communication;

	@Column(name = "Enthusiasm")
	private Integer enthusiasm;

	@Column(name = "Notes")
	private String notes;

	@Column(name = "Offer_released")
	private Boolean offerReleased;

	@Column(name = "WorkExInYears")
	private Double workExInYears;

	@Column(name = "InterviewerName")
	private String interviewerName;

	@Column(name = "CandidateName")
	private String candidateName;

	@Column(name = "Source")
	private String source;

	@Column(name = "OfferAccepted")
	private Boolean offerAccepted;

	@Column(name = "Type")
	private String type;

	@Column(name = "interview_date")
	private LocalDate date;

	@Column(name = "screening_round")
	private Boolean screeningRound;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "selected")
	private Boolean selected;

}
