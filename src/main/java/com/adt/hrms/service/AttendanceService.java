package com.adt.hrms.service;

import java.text.ParseException;

public interface AttendanceService {
	String setStatus(int id, String status) throws ParseException;

}
