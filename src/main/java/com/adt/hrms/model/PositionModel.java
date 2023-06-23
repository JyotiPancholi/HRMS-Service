package com.adt.hrms.model;

import java.time.LocalDateTime;
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

@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "PositionModel")
public class PositionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "positionId")
	private Integer positionId;

	private String positionName;

	@ElementCollection
	@CollectionTable(catalog = "EmployeeDB", schema = "employee_schema", name = "TECH_STACK", joinColumns = @JoinColumn(name = "POSITION_ID"))
	@Column(name = "tech_stack")
	private List<String> techStack;

	private LocalDateTime positionOpenDate;

	private LocalDateTime positionCloseDate;

	private String status;

	private Double experienceInYear;

	private Boolean remote;

	private String positionType;

	private Integer vacancy;

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public List<String> getTechStack() {
		return techStack;
	}

	public void setTechStack(List<String> techStack) {
		this.techStack = techStack;
	}

	public LocalDateTime getPositionOpenDate() {
		return positionOpenDate;
	}

	public void setPositionOpenDate(LocalDateTime positionOpenDate) {
		this.positionOpenDate = positionOpenDate;
	}

	public LocalDateTime getPositionCloseDate() {
		return positionCloseDate;
	}

	public void setPositionCloseDate(LocalDateTime positionCloseDate) {
		this.positionCloseDate = positionCloseDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getExperienceInYear() {
		return experienceInYear;
	}

	public void setExperienceInYear(Double experienceInYear) {
		this.experienceInYear = experienceInYear;
	}

	public Boolean getRemote() {
		return remote;
	}

	public void setRemote(Boolean remote) {
		this.remote = remote;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public Integer getVacancy() {
		return vacancy;
	}

	public void setVacancy(Integer vacancy) {
		this.vacancy = vacancy;
	}

	public PositionModel(Integer positionId, String positionName, List<String> techStack,
			LocalDateTime positionOpenDate, LocalDateTime positionCloseDate, String status, Double experienceInYear,
			Boolean remote, String positionType, Integer vacancy) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.techStack = techStack;
		this.positionOpenDate = positionOpenDate;
		this.positionCloseDate = positionCloseDate;
		this.status = status;
		this.experienceInYear = experienceInYear;
		this.remote = remote;
		this.positionType = positionType;
		this.vacancy = vacancy;
	}

	public PositionModel() {
		super();
	}

	@Override
	public String toString() {
		return "PositionModel [positionId=" + positionId + ", positionName=" + positionName + ", techStack=" + techStack
				+ ", positionOpenDate=" + positionOpenDate + ", positionCloseDate=" + positionCloseDate + ", status="
				+ status + ", experienceInYear=" + experienceInYear + ", remote=" + remote + ", positionType="
				+ positionType + ", vacancy=" + vacancy + "]";
	}

}