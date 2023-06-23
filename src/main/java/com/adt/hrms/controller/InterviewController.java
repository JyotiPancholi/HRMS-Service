package com.adt.hrms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adt.hrms.model.AVTechnology;
import com.adt.hrms.model.Interview;
import com.adt.hrms.model.PositionModel;
import com.adt.hrms.service.AVTechnologyService;
import com.adt.hrms.service.InterviewCandidateService;
import com.adt.hrms.service.InterviewService;
import com.adt.hrms.service.PositionService;
import com.adt.hrms.ui.InterviewModelDTO;
import com.adt.hrms.ui.PositionDateConverter;
import com.adt.hrms.ui.PositionUIModel;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PositionService positionService;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private InterviewCandidateService intwCandidateService;
	@Autowired
	private AVTechnologyService avTechnologyService;

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PostMapping("/addPosition")
	public ResponseEntity<String> savePosition(@RequestBody PositionModel pm) {
		LOGGER.info("Employeeservice:InterviewPosition:savePosition info level log message");
		return new ResponseEntity<>(positionService.savePosition(pm), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getAllPosition")
	public ResponseEntity<List<PositionUIModel>> getAllPosition() {
		LOGGER.info("Employeeservice:InterviewPosition:getAllPosition info level log message");
		return new ResponseEntity<>(positionService.getAllUIPosition(), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getByPositionId/{id}")
	public ResponseEntity<PositionModel> getByPositionId(@PathVariable("id") Integer id) {
		LOGGER.info("Employeeservice:InterviewPosition:getByPositionId info level log message");
		return new ResponseEntity<PositionModel>(positionService.getPosition(id), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PutMapping("/updatePosition")
	public ResponseEntity<String> updatePosition(@RequestBody PositionModel pm) {
		LOGGER.info("Employeeservice:InterviewPosition:updatePosition info level log message");
		return new ResponseEntity<>(positionService.updatePosition(pm), HttpStatus.OK);
	}

//	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
//	@PostMapping("/saveInterviewDetails")
//	public ResponseEntity<String> saveInterviewDetails(@RequestBody Interview interviewRequest) {
//		LOGGER.info("Employeeservice:Interview:saveInterviewDetails info level log message");
//		return new ResponseEntity<>(interviewService.saveInterview(interviewRequest), HttpStatus.OK);
//	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getAllInterviewDetails")
	public ResponseEntity<List<Interview>> getAllInterviewDetails() {
		LOGGER.info("Employeeservice:InterviewDetails:getAllInterviewDetails info level log message");
		return new ResponseEntity<>(interviewService.listAllInterviewDetails(), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PutMapping("/updateInterviewDetails")
	public ResponseEntity<String> updateInterviewDetails(@RequestBody Interview interviewRequest) {
		LOGGER.info("Employeeservice:Interview:updateInterviewDetails info level log message");
		return new ResponseEntity<>(interviewService.updateToInterviewDetails(interviewRequest), HttpStatus.OK);
	}

//	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
//	@GetMapping("/findByDetailsByEmployeeId/{empId}")
//	public ResponseEntity<Interview> findEmployeeIPByEmployeeId(@PathVariable("empId") Integer empId) {
//		LOGGER.info("Employeeservice:Interview:findEmployeeIPByEmployeeId info level log message");
//		return new ResponseEntity<Interview>(interviewService.getInterviewDetailsById(empId), HttpStatus.OK);
//	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PostMapping("/savePosition")
	public ResponseEntity<String> savePositionNew(@RequestBody PositionDateConverter pdc) {
		LOGGER.info("Employeeservice:InterviewPosition:savePositionNew info level log message");
		return new ResponseEntity<>(positionService.savePositionNew(pdc), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getAllPositionNew")
	public ResponseEntity<List<PositionDateConverter>> getAllPositionNew() {
		LOGGER.info("Employeeservice:InterviewPosition:getAllPositionNew info level log message");
		return new ResponseEntity<>(positionService.getAllPositionNew(), HttpStatus.OK);
	}

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getInterviewDetailByIdAndRound")
	public ResponseEntity<Interview> getInterviewDetailByIDAndRound(@RequestParam("interviewId") int interviewId,
			@RequestParam("round") int round) {
		LOGGER.info("Employeeservice:InterviewController:getInterviewDetailByID info level log message");
		Interview interview = interviewService.getInterviewDetailByInterviewIdAndRound(interviewId, round);
		if (interview == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(interview);
	}
	//HRMS-66 START Added new method
	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PutMapping("/updateInterviewByIdAndRound")
	public ResponseEntity<String> updateInterviewDetailByInterviewIDAndRound(@RequestBody InterviewModelDTO intwDTO) {

		LOGGER.info("EmployeeService:InterviewController:updateInterviewDetailByInterviewIDAndRound info level log message");
		
		int interviewIdFromReq = intwDTO.getInterviewId();
		int roundIdFromReq = intwDTO.getRounds();
		
		Interview interviewFromDB = interviewService.getInterviewDetailByInterviewIdAndRound(interviewIdFromReq, roundIdFromReq);

		if (interviewFromDB == null)
			return new ResponseEntity<String>("Data not found", HttpStatus.NOT_FOUND);

		else {
			Interview updatedInterviewDetail = interviewService.updateInterviewDetailByInterviewIdAndRound(interviewIdFromReq,
					roundIdFromReq, intwDTO);
			return new ResponseEntity<String>("Interview with ID:- " + updatedInterviewDetail.getInterviewId()
			+ " and round:- " + "" + updatedInterviewDetail.getRounds() + " Updated succesfully",
			HttpStatus.OK);
		}
	}
	//HRMS-66  

	@GetMapping("/alltech")
	public ResponseEntity<List<AVTechnology>> getAllTechnologies() {
		LOGGER.info("EmployeeService:InterviewController:getAllTechnologies info level log message");
		return new ResponseEntity<List<AVTechnology>>(avTechnologyService.getAllTechnology(), HttpStatus.OK);
	}

	//HRMS-66 START Added new method
	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PostMapping("/saveInterviewNew")
	public ResponseEntity<String> saveInterviewNew(@RequestBody InterviewModelDTO intwDto) {
		LOGGER.info("EmployeeService:InterviewController:saveInterviewNew info level log message");
		String status = interviewService.saveInterviewNew(intwDto);
		if(status != null) {
			return ResponseEntity.ok("Interview record saved successfully...");
		}
		return new ResponseEntity<String>("Record already present", HttpStatus.BAD_REQUEST);
	}
	//HRMS-66 END

}
