package com.adt.hrms.service;

import java.util.List;

import com.adt.hrms.model.InterviewRounds;

public interface InterviewRoundService {

	public String saveInterviewRounds(InterviewRounds ir);

	public List<InterviewRounds> getAllInterviewRounds();

	public String updateInterviewRounds(InterviewRounds ir);

	public InterviewRounds getInterviewRoundsById(Integer id);

}
