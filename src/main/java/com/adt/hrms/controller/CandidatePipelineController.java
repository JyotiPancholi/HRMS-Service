package com.adt.hrms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adt.hrms.model.CandidatePipeline;
import com.adt.hrms.model.InterviewRounds;
import com.adt.hrms.service.CandidatePipelineService;
import com.adt.hrms.service.InterviewRoundService;

@RestController
@RequestMapping("/candidatePipeline")
public class CandidatePipelineController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CandidatePipelineService candidatePipelineService;

	@Autowired
	private InterviewRoundService interviewRoundService;

	@PostMapping("saveCandidate")
	public ResponseEntity<String> saveCandidatePipeline(@RequestBody CandidatePipeline cp) {
		LOGGER.info("Employeeservice:CandidatePipelineController:saveCandidatePipeline info level log message");
		return new ResponseEntity<>(candidatePipelineService.saveCandidatePipelineDetails(cp), HttpStatus.OK);
	}

	@GetMapping("/getCandidatePipelineDetails")
	public ResponseEntity<List<CandidatePipeline>> getAllCandidatePipeline() {
		LOGGER.info("Employeeservice:CandidatePipelilne:getAllCandidatePipeline info level log message");
		return new ResponseEntity<>(candidatePipelineService.getAllCandidatePipeline(), HttpStatus.OK);

	}

	@PutMapping("/updateCandidatePipelineDetails")
	public ResponseEntity<String> updateCandidatePipelineDetails(@RequestBody CandidatePipeline cp) {
		LOGGER.info("Employeeservice:CandidatePipelilne:updateCandidatePipelineDetails info level log message");
		return new ResponseEntity<>(candidatePipelineService.updateCandidatePipelineDetails(cp), HttpStatus.OK);
	}

	@GetMapping("/getCandidatePipelineById/{id}")
	public ResponseEntity<CandidatePipeline> getCandidatePipelineDetailsById(@PathVariable("id") Integer id) {
		LOGGER.info("Employeeservice:CandidatePipelilne:getCandidatePipelineDetailsById info level log message");
		return new ResponseEntity<>(candidatePipelineService.getCandidatePipelineById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCandidatePipelineById/{id}")
	public ResponseEntity<String> deleteCandidatePipelineById(@PathVariable("id") Integer id) {
		LOGGER.info("Employeeservice:CandidatePipelilne:deleteCandidatePipelineById info level log message");
		return new ResponseEntity<>(candidatePipelineService.deleteCandidateById(id), HttpStatus.OK);
	}

	@PostMapping("/saveInterviewRounds")
	public ResponseEntity<String> saveInterviewRouds(@RequestBody InterviewRounds ir) {
		LOGGER.info("Employeeservice:CandidatePipelilne:saveInterviewRouds info level log message");
		return new ResponseEntity<>(interviewRoundService.saveInterviewRounds(ir), HttpStatus.OK);
	}

	@GetMapping("/getAllInterviewRounds")
	public ResponseEntity<List<InterviewRounds>> getAllInterviewRounds() {
		LOGGER.info("Employeeservice:CandidatePipelilne:getAllInterviewRounds info level log message");
		return new ResponseEntity<List<InterviewRounds>>(interviewRoundService.getAllInterviewRounds(), HttpStatus.OK);
	}

	@PutMapping("/updateInterviewRounds")
	public ResponseEntity<String> updateInterviewRounds(@RequestBody InterviewRounds ir) {
		LOGGER.info("Employeeservice:CandidatePipelilne:updateInterviewRounds info level log message");
		return new ResponseEntity<>(interviewRoundService.updateInterviewRounds(ir), HttpStatus.OK);
	}

	@GetMapping("/getInterviewRoundsById/{id}")
	public ResponseEntity<InterviewRounds> getInterviewRoundsById(@PathVariable("id") Integer id) {
		LOGGER.info("Employeeservice:CandidatePipelilne:getInterviewRoundsById info level log message");
		return new ResponseEntity<>(interviewRoundService.getInterviewRoundsById(id), HttpStatus.OK);
	}
}
