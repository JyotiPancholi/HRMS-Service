package com.adt.hrms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.AttendanceModel;
import com.adt.hrms.model.Employee;
import com.adt.hrms.repository.AttendanceRepository;
import com.adt.hrms.repository.EmployeeRepo;
import com.adt.hrms.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String setStatus(int id, String status) throws ParseException {
        AttendanceModel attendanceStatus = new AttendanceModel();
        Optional<Employee> employee = employeeRepo.findById(id);
        String name = employee.get().getFirstName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = String.valueOf(dtf.format(now));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.now();
        String date = String.valueOf(ld);
        AttendanceModel ats = attendanceRepository.findByAttendanceIdAndDate(id, date);
        attendanceStatus.setDate(date);
        attendanceStatus.setAttendanceId(id);
        if (status.equalsIgnoreCase("checkIn")) {
            if (attendanceRepository.findByAttendanceIdAndDate(id, date) == null) {
                attendanceStatus.setCheckIn(time);
                attendanceRepository.save(attendanceStatus);
                return name + " check In successfully AT :" + time;
            } else {
                return name + " you are already check In for today";
            }
        } else if (status.equalsIgnoreCase("checkout")) {
            if (attendanceRepository.findByAttendanceIdAndDate(id, date) != null) {
                if (ats.getCheckOut() != null) {
                    return name + " you are already check out for today";
                } else {
                    attendanceStatus.setCheckIn(ats.getCheckIn());
                    attendanceStatus.setCheckOut(time);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    Date date1 = simpleDateFormat.parse(attendanceStatus.getCheckOut());
                    Date date2 = simpleDateFormat.parse(attendanceStatus.getCheckIn());
                    long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
                    long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
                    long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
                    long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;
                    attendanceStatus.setWorkingHour(differenceInHours + ":" + differenceInMinutes + ":" + differenceInSeconds);
                    attendanceRepository.save(attendanceStatus);
                    return name + " checkout successfully AT :" + time;
                }
            }
            return name + " you are not check in yet";
        } else {
            return "Invalid Status";
        }
    }
}