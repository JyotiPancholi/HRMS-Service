package com.adt.hrms.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adt.hrms.model.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Serializable> {
	
//	public Interview findById(int id);
	
	//HRMS-56 START
	@Query("select i from Interview i where i.interviewId = ?1 and i.rounds = ?2")
	public Optional<Interview> getInterviewDetailByInterviewIdAndRound(int interviewId, int round);
	//HRMS-56 END
	
	

}
