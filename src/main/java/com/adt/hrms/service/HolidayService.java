package com.adt.hrms.service;

import java.util.List;

import com.adt.hrms.model.Holiday;

public interface HolidayService {
	
	public String saveHoliday(String holidayName, String date);
	
	public List<Holiday> getAllHolidays();
	
	public String downloadHolidayCalendar();
	
	public String updateHolidayCalendar(Integer hId, String holidayName, String date);
	
	public String deleteHolidayFromCalendar(Integer hId);
	
	public Holiday getHolidayById(Integer hId);

}
