package com.adt.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.InterviewRounds;
import com.adt.hrms.repository.InterviewRoundsRepo;
import com.adt.hrms.service.InterviewRoundService;

@Service
public class InterviewRoundServiceImpl implements InterviewRoundService {

	@Autowired
	private InterviewRoundsRepo interviewRoundsRepo;

	@Override
	public String saveInterviewRounds(InterviewRounds ir) {
		Optional<InterviewRounds> opt = interviewRoundsRepo.findById(ir.getId());
		if (opt.isPresent())
			return "InterviewRounds with InterviewId " + ir.getInterviewId()
					+ " is alredy avalable Pls Insert new ID....";

		return interviewRoundsRepo.save(ir).getInterviewId() + " Interview Round Saved";
	}

	@Override
	public List<InterviewRounds> getAllInterviewRounds() {
		List<InterviewRounds> list = interviewRoundsRepo.findAll();
		return list;
	}

	@Override
	public String updateInterviewRounds(InterviewRounds ir) {

		return interviewRoundsRepo.save(ir).getId() + "Details Updated Susccessfully";
	}

	@Override
	public InterviewRounds getInterviewRoundsById(Integer id) {
		Optional<InterviewRounds> opt = interviewRoundsRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

}
