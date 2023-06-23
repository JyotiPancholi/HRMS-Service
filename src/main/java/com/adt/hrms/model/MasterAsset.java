package com.adt.hrms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Data;

//JyotiPancholi - Jira no ->  HRMS-63(START)

@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "masterasset")
@Proxy(lazy = false)
@Data
public class MasterAsset {

	@Id
//	@SequenceGenerator(name = "masterassetgen", sequenceName = "MasterAssetSequence", initialValue = 1, allocationSize = 1)
//	@GeneratedValue(generator = "masterassetgen", strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;
	private String assetUser;
	private String assetName;
	@Column(unique = true)
	private String assetId;
	private String assetNo;
	private String assetType;
	private String processor;
	private String ram;
	private String diskType;
	private String operatingSystem;
	private LocalDate purchesDate;
	private String warrenty;
	private LocalDate warrentyDate;
	private String status;
}
//JyotiPancholi - Jira no ->  HRMS-63(END)
