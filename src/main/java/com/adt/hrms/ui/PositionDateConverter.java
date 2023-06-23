package com.adt.hrms.ui;

import java.util.List;

import javax.persistence.Id;

public class PositionDateConverter {

	@Id
	private Integer uiid;

	private String positionName;

	private List<String> techStack;

	private String positionopendate;

	private String positionclosedate;

	private String status;

	private double experienceInYear;

	private boolean remote;

	private String positionType;

	private Integer vacancy;

	public Integer getUiid() {
		return uiid;
	}

	public void setUiid(Integer uiid) {
		this.uiid = uiid;
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

	public String getPositionopendate() {
		return positionopendate;
	}

	public void setPositionopendate(String positionopendate) {
		this.positionopendate = positionopendate;
	}

	public String getPositionclosedate() {
		return positionclosedate;
	}

	public void setPositionclosedate(String positionclosedate) {
		this.positionclosedate = positionclosedate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getExperienceInYear() {
		return experienceInYear;
	}

	public void setExperienceInYear(double experienceInYear) {
		this.experienceInYear = experienceInYear;
	}

	public boolean isRemote() {
		return remote;
	}

	public void setRemote(boolean remote) {
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

	public PositionDateConverter(Integer uiid, String positionName, List<String> techStack, String positionopendate,
			String positionclosedate, String status, double experienceInYear, boolean remote, String positionType,
			Integer vacancy) {
		super();
		this.uiid = uiid;
		this.positionName = positionName;
		this.techStack = techStack;
		this.positionopendate = positionopendate;
		this.positionclosedate = positionclosedate;
		this.status = status;
		this.experienceInYear = experienceInYear;
		this.remote = remote;
		this.positionType = positionType;
		this.vacancy = vacancy;
	}

	@Override
	public String toString() {
		return "PositionDateConverter [uiid=" + uiid + ", positionName=" + positionName + ", techStack=" + techStack
				+ ", positionopendate=" + positionopendate + ", positionclosedate=" + positionclosedate + ", status="
				+ status + ", experienceInYear=" + experienceInYear + ", remote=" + remote + ", positionType="
				+ positionType + ", vacancy=" + vacancy + "]";
	}

	public PositionDateConverter() {
		super();
	}
}