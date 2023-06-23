package com.adt.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adt.hrms.model.ImageDataModel;

public interface ImageRepository extends JpaRepository<ImageDataModel, Integer> {

	@Query(value="SELECT pic FROM payroll_schema.image WHERE id = 1", nativeQuery=true)
	byte[] getImageData();
	
}