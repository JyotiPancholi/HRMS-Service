package com.adt.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(catalog = "EmployeeDB", schema = "payroll_schema", name = "image")
public class ImageDataModel {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "pic")
	private byte[] pic;

}
