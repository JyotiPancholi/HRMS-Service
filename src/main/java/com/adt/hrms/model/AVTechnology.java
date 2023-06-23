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
@Table(catalog = "EmployeeDB", schema = "av_schema", name = "Technology")
public class AVTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tech_id")
	private Integer techId;

	@Column(name = "description")
	private String description;

}
