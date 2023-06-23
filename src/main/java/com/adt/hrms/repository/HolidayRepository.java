package com.adt.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adt.hrms.model.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

	@Query(value = "SELECT * FROM employee_schema.holiday ORDER BY id LIMIT 1", nativeQuery = true)
	public Holiday getFirstHolidayRecord();
	
}