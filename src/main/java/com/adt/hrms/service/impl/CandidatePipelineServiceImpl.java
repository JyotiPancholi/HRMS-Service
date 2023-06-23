package com.adt.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.CandidatePipeline;
import com.adt.hrms.repository.CandidatePipelineRepo;
import com.adt.hrms.service.CandidatePipelineService;

@Service
public class CandidatePipelineServiceImpl implements CandidatePipelineService {
	
	@Autowired
	private CandidatePipelineRepo candidatePipelineRepo;

	@Override
	public String saveCandidatePipelineDetails(CandidatePipeline cp) {
		Optional<CandidatePipeline> opt = candidatePipelineRepo.findById(cp.getId());
		if(opt.isPresent())
			return "CandidatepPipeline with Id"+cp.getId()+" is alredy avalable Pls Insert new ID....";
		return candidatePipelineRepo.save(cp).getId()+" CandidatePipeline is Saved";
	}

	@Override
	public List<CandidatePipeline> getAllCandidatePipeline() {
		List<CandidatePipeline> list = candidatePipelineRepo.findAll();
		return list;
		}

	@Override
	public String updateCandidatePipelineDetails(CandidatePipeline cp) {
		
		return candidatePipelineRepo.save(cp).getId()+" Details Updated Successfully";
	}

	@Override
	public CandidatePipeline getCandidatePipelineById(Integer id) {
		Optional<CandidatePipeline> opt = candidatePipelineRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@Override
	public String deleteCandidateById(Integer id) {
		Optional<CandidatePipeline> opt = candidatePipelineRepo.findById(id);
		if(opt.isPresent()) {
			candidatePipelineRepo.deleteById(id);
			return id+" has been Deleted";
		}
		else
			return "Invalid Employee Id :: "+ id;
	}
	

}
