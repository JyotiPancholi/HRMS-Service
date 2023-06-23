package com.adt.hrms.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.hrms.model.EmployeeStatus;

public interface EmployeeStatusRepo extends JpaRepository<EmployeeStatus, Serializable> {
	

}
