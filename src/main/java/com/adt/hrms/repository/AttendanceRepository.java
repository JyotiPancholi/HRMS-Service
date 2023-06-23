package com.adt.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adt.hrms.model.AttendanceModel;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceModel, Integer> {

	AttendanceModel findByAttendanceIdAndDate(int id, String localDates);

	AttendanceModel findByAttendanceId(int id);

	void deleteByAttendanceIdAndDate(int id, String localDates);

}
