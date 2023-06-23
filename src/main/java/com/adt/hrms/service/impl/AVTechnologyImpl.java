package com.adt.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.AVTechnology;
import com.adt.hrms.repository.AVTechnologyRepo;
import com.adt.hrms.service.AVTechnologyService;

@Service
public class AVTechnologyImpl implements AVTechnologyService {

	@Autowired
	AVTechnologyRepo avTechnologyRepo;

	@Override
	public String saveTechnology(AVTechnology tc) {
		return avTechnologyRepo.save(tc).getTechId()+" Technology is Saved";
	}

	@Override
	public List<AVTechnology> getAllTechnology() {
		List<AVTechnology> tech = avTechnologyRepo.findAll();
		return tech;
	}

	@Override
	public AVTechnology getTechnology(Integer techId) {
		Optional<AVTechnology> opt = avTechnologyRepo.findById(techId);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

}
