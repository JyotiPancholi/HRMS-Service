package com.adt.hrms.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(catalog = "EmployeeDB", schema = "employee_schema", name = "holiday")
@Data
@NoArgsConstructor
@ToString
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int hId;
	
	@Column(name = "holiday_name")
	private String holidayName;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "month")
	private String month; 
	
	@Column(name = "day")
	private String day;
}

