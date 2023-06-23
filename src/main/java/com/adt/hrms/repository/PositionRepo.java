package com.adt.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.hrms.model.PositionModel;

public interface PositionRepo extends JpaRepository<PositionModel, Integer> {

}
