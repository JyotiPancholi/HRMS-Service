package com.adt.hrms.service;

import com.adt.hrms.model.InterviewCandidateDetails;

import java.util.List;

public interface InterviewCandidateService {

	/**
	 * This method is used for
	 * 
	 * @Param interviewCandidateDetails
	 * @return String
	 * @throws NoSuchFieldException
	 */
	public String saveInterviewCandidateDetail(InterviewCandidateDetails interviewCandidateDetails);

	/**
	 * This method is used for
	 * 
	 * @return List<InterviewCandidateDetails>
	 * @throws NoSuchFieldException
	 */
	public List<InterviewCandidateDetails> getAllInterviewCandidateDetail();

	/**
	 * This method is used for
	 * 
	 * @Param candidateId, interviewCandidateDetails
	 * @return String
	 * @throws NoSuchFieldException
	 */
	public String updateInterviewCandidateDetail(int candidateId, InterviewCandidateDetails interviewCandidateDetails);

	/**
	 * This method is used for
	 * 
	 * @Param candidateId
	 * @return InterviewCandidateDetails
	 */
	public InterviewCandidateDetails getInterviewCandidateById(int candidateId);

	/**
	 * This method is used for
	 * 
	 * @Param candidateId
	 * @return String
	 */
	public String deleteInterviewCandidateById(int candidateId);
}
