package com.adt.hrms.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.adt.hrms.model.AVPositionTypeModel;
import com.adt.hrms.model.AVStatus;
import com.adt.hrms.model.AVTechnology;
import com.adt.hrms.repository.AVPositionTypeRepo;
import com.adt.hrms.repository.AVStatusRepo;
import com.adt.hrms.repository.AVTechnologyRepo;
import com.adt.hrms.util.InMemoryMap;

public class AVHashMapServiceImpl implements CommandLineRunner {

	@Autowired
	private AVTechnologyRepo technologyRepo;

	@Autowired
	private AVPositionTypeRepo positionTypeRepo;

	@Autowired
	private AVStatusRepo avStatusRepo;

	@Override
	public void run(String... args) throws Exception {

		InMemoryMap.avtechnologymap.putAll(technologyRepo.findAll().stream()
				.collect(Collectors.toMap(AVTechnology::getDescription, AVTechnology::getDescription)));
		System.out.println(InMemoryMap.avtechnologymap);

		InMemoryMap.avpositiontypemap.putAll(positionTypeRepo.findAll().stream()
				.collect(Collectors.toMap(AVPositionTypeModel::getDescription, AVPositionTypeModel::getDescription)));
		System.out.println(InMemoryMap.avpositiontypemap);

		InMemoryMap.avstatusmap.putAll(avStatusRepo.findAll().stream()
				.collect(Collectors.toMap(AVStatus::getDescription, AVStatus::getDescription)));
		System.out.println(InMemoryMap.avstatusmap);

	}

}