package com.adt.hrms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adt.hrms.model.Holiday;
import com.adt.hrms.service.HolidayService;

@RestController
@RequestMapping("/holiday")
public class HolidayController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HolidayService holidayService;

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PostMapping("/saveHolidayDate")
	public ResponseEntity<String> addHolidayDate(@RequestParam("holidayName") String holidayName, @RequestParam("date") String date){
		LOGGER.info("EmployeeService:HolidayController:addHolidayDate");
		String savedHolidayStatus = holidayService.saveHoliday(holidayName, date);

		if(savedHolidayStatus.toLowerCase().contains("holiday already present") || savedHolidayStatus.toLowerCase().contains("date already present"))
			return ResponseEntity.badRequest().body(savedHolidayStatus);
		else if(savedHolidayStatus.toLowerCase().contains("not saved"))
			return ResponseEntity.internalServerError().body("Error occurred. Data not saved..");
		
		else return ResponseEntity.ok(savedHolidayStatus);
	}

	@GetMapping("/getHolidayCalendar")
	@PreAuthorize("@auth.allow('ROLE_ADMIN') or @auth.allow('ROLE_USER')")
	public ResponseEntity<List<Holiday>> getHolidayCalendar(){
		LOGGER.info("EmployeeService:HolidayController:getHolidayCalendar");
		List<Holiday> listOfHolidays = holidayService.getAllHolidays();

		if(listOfHolidays.size() <= 0)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(listOfHolidays);
	}

	@GetMapping("/downloadHolidayCalendar")
	public ResponseEntity<String> downloadHolidayCalendar(){
		LOGGER.info("EmployeeService:HolidayController:downloadHolidayCalendar");
		String downloadedCalendarStatus = holidayService.downloadHolidayCalendar();
		
		if(downloadedCalendarStatus.equalsIgnoreCase("Holiday Calendar is unavailable"))
			return new ResponseEntity<String>(downloadedCalendarStatus, HttpStatus.NOT_FOUND);
		
		else if(downloadedCalendarStatus.equalsIgnoreCase("File not downloaded"))
			return ResponseEntity.internalServerError().body(downloadedCalendarStatus);
		
		return ResponseEntity.ok(downloadedCalendarStatus);
		
	}
	
	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PutMapping("/updateHolidayCalendar/{id}")
	public ResponseEntity<String> updateHolidayCalendar(@PathVariable(value = "id") Integer hId, @RequestParam(value = "holidayName") String holidayName, @RequestParam(value = "date") String date){
		LOGGER.info("EmployeeService:HolidayController:updateHolidayCalendar");
		String status = holidayService.updateHolidayCalendar(hId, holidayName, date);
		
		if(status.contains("not updated"))
			return ResponseEntity.internalServerError().body(status);
		return ResponseEntity.ok(status);
	}
	
	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@DeleteMapping("/deleteHolidayById/{id}")
	public ResponseEntity<String> deleteHoliday(@PathVariable("id") Integer id){
		LOGGER.info("EmployeeService:HolidayController:deleteHoliday");
		String status = holidayService.deleteHolidayFromCalendar(id);
		
		if(status.contains("not deleted"))
			return new ResponseEntity<String>(status, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String>(status, HttpStatus.NO_CONTENT);
	}
	
	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@GetMapping("/getHolidayByID/{id}")
	public ResponseEntity<Holiday> getHolidayById(@PathVariable("id") Integer hId){
		LOGGER.info("EmployeeService:HolidayController:getHolidayById");
		Holiday holiday = holidayService.getHolidayById(hId);
		
		if(holiday == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(holiday);
	}


}