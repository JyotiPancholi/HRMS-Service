package com.adt.hrms.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.hrms.model.AVTechnology;

public interface AVTechnologyRepo extends JpaRepository<AVTechnology, Serializable> {

}
