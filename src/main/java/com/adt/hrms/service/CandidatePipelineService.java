package com.adt.hrms.service;

import java.util.List;

import com.adt.hrms.model.CandidatePipeline;

public interface CandidatePipelineService {

	public String saveCandidatePipelineDetails(CandidatePipeline cp);

	public List<CandidatePipeline> getAllCandidatePipeline();

	public String updateCandidatePipelineDetails(CandidatePipeline cp);

	public CandidatePipeline getCandidatePipelineById(Integer id);

	public String deleteCandidateById(Integer id);

}
