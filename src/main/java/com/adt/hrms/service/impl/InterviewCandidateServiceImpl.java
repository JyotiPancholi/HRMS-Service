package com.adt.hrms.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.InterviewCandidateDetails;
import com.adt.hrms.repository.InterviewCandidateRepo;
import com.adt.hrms.service.InterviewCandidateService;
import com.adt.hrms.util.MobileNumberValidation;

@Service
public class InterviewCandidateServiceImpl implements InterviewCandidateService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InterviewCandidateRepo interviewCandidateRepo;

	@Autowired
	private MessageSource messageSource;

	@Override
	public String saveInterviewCandidateDetail(InterviewCandidateDetails interviewCandidateDetails) {
		List<InterviewCandidateDetails> opt = interviewCandidateRepo
				.findCandidateDetailsByEmailId(interviewCandidateDetails.getEmailId());
		if (opt.size() > 0)
			return "Interview Candidate With Id: " + opt.get(0).getCandidateId() + " is Already Present";
		if (!MobileNumberValidation.isValidMobileNo(interviewCandidateDetails.getContactNo()))
			return "Interview Candidate Contact Number: " + interviewCandidateDetails.getContactNo() + " is Invalid";
		return "Candidate With Id: " + interviewCandidateRepo.save(interviewCandidateDetails).getCandidateId()
				+ " is Successfully Saved";
	}

	@Override
	public List<InterviewCandidateDetails> getAllInterviewCandidateDetail() {
		List<InterviewCandidateDetails> interviewCandidateDetails = interviewCandidateRepo.findAll();
		return interviewCandidateDetails;
	}

	@Override
	public String updateInterviewCandidateDetail(int candidateId, InterviewCandidateDetails interviewCandidateDetails) {
		Optional<InterviewCandidateDetails> candidateDetails = interviewCandidateRepo.findById(candidateId);
		if (!candidateDetails.isPresent())
			return "Candidate With Id: " + candidateId + " is Not Present";
		if (!MobileNumberValidation.isValidMobileNo(interviewCandidateDetails.getContactNo()))
			return "Candidate With Id: " + candidateId + " is Invalid Contact Number";
		candidateDetails.get().setCandidateName(interviewCandidateDetails.getCandidateName());
		candidateDetails.get().setEmailId(interviewCandidateDetails.getEmailId());
		candidateDetails.get().setContactNo(interviewCandidateDetails.getContactNo());
		candidateDetails.get().setAddress(interviewCandidateDetails.getAddress());
		candidateDetails.get().setCvShortlisted(interviewCandidateDetails.isCvShortlisted());
		candidateDetails.get().setLastCTC(interviewCandidateDetails.getLastCTC());
		candidateDetails.get().setHighestQualification(interviewCandidateDetails.getHighestQualification());
		candidateDetails.get().setNoticePeriod(interviewCandidateDetails.getNoticePeriod());
		candidateDetails.get().setTechnicalStack(interviewCandidateDetails.getTechnicalStack());
		candidateDetails.get().setWorkExperience(interviewCandidateDetails.getWorkExperience());
		candidateDetails.get().setDob(interviewCandidateDetails.getDob());
		return "Candidate With Id: " + interviewCandidateRepo.save(candidateDetails.get()).getCandidateId()
			+ " is Successfully Updated";
	}

	@Override
	public InterviewCandidateDetails getInterviewCandidateById(int candidateId) {
		Optional<InterviewCandidateDetails> candidateDetail = interviewCandidateRepo.findById(candidateId);
		if (!candidateDetail.isPresent()) {
			String message = messageSource.getMessage("api.error.data.not.found.id", null, Locale.ENGLISH);
			LOGGER.error(message = message + candidateId);
			throw new EntityNotFoundException(message);
		}
		return candidateDetail.get();
	}

	@Override
	public String deleteInterviewCandidateById(int candidateId) {
		if (interviewCandidateRepo.existsById(candidateId)) {
			interviewCandidateRepo.deleteById(candidateId);
			return "Candidate With id: " + candidateId + " is Successfully Deleted";
		}
		return "Candidate With id: " + candidateId + " is Not Present";
	}
}
