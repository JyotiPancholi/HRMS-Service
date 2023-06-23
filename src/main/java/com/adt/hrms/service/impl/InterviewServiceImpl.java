package com.adt.hrms.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.AVTechnology;
import com.adt.hrms.model.Interview;
import com.adt.hrms.model.InterviewCandidateDetails;
import com.adt.hrms.model.PositionModel;
import com.adt.hrms.repository.AVTechnologyRepo;
import com.adt.hrms.repository.InterviewCandidateRepo;
import com.adt.hrms.repository.InterviewRepository;
import com.adt.hrms.repository.PositionRepo;
import com.adt.hrms.service.InterviewService;
import com.adt.hrms.ui.InterviewModelDTO;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;
	@Autowired
	private InterviewCandidateRepo interviewCandidateRepo;
	@Autowired
	private PositionRepo posRepo;
	@Autowired
	private AVTechnologyRepo techRepo;

	@Override
	public String saveInterview(Interview in) {
		interviewRepository.save(in);
		return " New interview ID is Saved";

	}

	@Override
	public List<Interview> listAllInterviewDetails() {
		List<Interview> list = interviewRepository.findAll();
		return list;
	}

	@Override
	public String updateToInterviewDetails(Interview emp) {
		return interviewRepository.save(emp).getInterviewId() + " Details Updated Successfully!";
	}

	@Override
	public Interview getInterviewDetailsById(Integer empId) {
		Optional<Interview> opt = interviewRepository.findById(empId);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@Override
	public Interview getInterviewDetailByInterviewIdAndRound(Integer interviewId, Integer round) {
		Optional<Interview> optional = interviewRepository.getInterviewDetailByInterviewIdAndRound(interviewId, round);
		if (!optional.isPresent())
			return null;
		return optional.get();
	}

	// HRMS-66 START Added new method
	@Override
	public Interview updateInterviewDetailByInterviewIdAndRound(Integer interviewId, Integer round,
			InterviewModelDTO intwDTO) {
		// TODO Auto-generated method stub

		Optional<Interview> opt = interviewRepository.getInterviewDetailByInterviewIdAndRound(interviewId, round);

		if (!opt.isPresent())
			return null;

		else {

			// *** Get the date from the request payload, and convert into LocalDate
			String date = intwDTO.getDate();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate localDate = LocalDate.parse(date);

			Integer position_id = intwDTO.getPosition_id();
			Integer tech_id = intwDTO.getTech_id();

			Optional<PositionModel> posDetails = posRepo.findById(position_id);
			Optional<AVTechnology> techDetails = techRepo.findById(tech_id);

			// opt.get().setCandidateName(intw.getCandidateName());
			opt.get().setClientName(intwDTO.getClientName());
			opt.get().setCommunication(intwDTO.getCommunication());
			opt.get().setDate(localDate);
			opt.get().setEnthusiasm(intwDTO.getEnthusiasm());
			opt.get().setInterviewerName(intwDTO.getInterviewerName());
			opt.get().setMarks(intwDTO.getMarks());
			opt.get().setNotes(intwDTO.getNotes());
			opt.get().setOfferAccepted(intwDTO.getOfferAccepted());
			opt.get().setOfferReleased(intwDTO.getOfferReleased());
			opt.get().setScreeningRound(intwDTO.getScreeningRound());
			opt.get().setSelected(intwDTO.getSelected());
			opt.get().setSource(intwDTO.getSource());
			opt.get().setType(intwDTO.getType());
			opt.get().setWorkExInYears(intwDTO.getWorkExInYears());
			if (posDetails.get() != null) {
				opt.get().setPosition_id(posDetails.get());
			}
			if (techDetails.get() != null) {
				opt.get().setTech_id(techDetails.get());
			}

			Interview updatedRecord = interviewRepository.save(opt.get());

			return updatedRecord;
		}
	}
	// HRMS-66 END

	// **** Added on 31/5/2023 ****
	// HRMS-66 START Added new method
	@Override
	public String saveInterviewNew(InterviewModelDTO intwDTO) {

		Integer interviewId = intwDTO.getInterviewId();
		Integer round = intwDTO.getRounds();

		// **** If the interview id and round is not present already, then only save,
		// otherwise return that the record is already present **
		Optional<Interview> opt = interviewRepository.getInterviewDetailByInterviewIdAndRound(interviewId, round);

		if (!opt.isPresent()) {

			Integer candidate_id = intwDTO.getCandidate_id();
			Integer position_id = intwDTO.getPosition_id();
			Integer tech_id = intwDTO.getTech_id();

			// ** Converting the date from request into LocalDate ***
			String date = intwDTO.getDate();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate localDate = LocalDate.parse(date);

			Optional<InterviewCandidateDetails> candidtateDetails = interviewCandidateRepo.findById(candidate_id);
			Optional<PositionModel> posDetails = posRepo.findById(position_id);
			Optional<AVTechnology> techDetails = techRepo.findById(tech_id);

			Interview intwEntity = new Interview();
			// *** Setting the values from DTO to the entity ****
			intwEntity.setInterviewId(intwDTO.getInterviewId());
			intwEntity.setRounds(intwDTO.getRounds());
			intwEntity.setClientName(intwDTO.getClientName());
			intwEntity.setCommunication(intwDTO.getCommunication());

			intwEntity.setDate(localDate);

			intwEntity.setEnthusiasm(intwDTO.getEnthusiasm());
			intwEntity.setInterviewerName(intwDTO.getInterviewerName());
			intwEntity.setMarks(intwDTO.getMarks());
			intwEntity.setNotes(intwDTO.getNotes());
			intwEntity.setOfferAccepted(intwDTO.getOfferAccepted());
			intwEntity.setOfferReleased(intwDTO.getOfferReleased());
			intwEntity.setScreeningRound(intwDTO.getScreeningRound());
			intwEntity.setSelected(intwDTO.getSelected());
			intwEntity.setSource(intwDTO.getSource());
			intwEntity.setType(intwDTO.getType());
			intwEntity.setWorkExInYears(intwDTO.getWorkExInYears());
			if (candidtateDetails.get() != null) {
				intwEntity.setCandidate_id(candidtateDetails.get());
				intwEntity.setCandidateName(candidtateDetails.get().getCandidateName());
			}
			if (posDetails.get() != null)
				intwEntity.setPosition_id(posDetails.get());
			if (techDetails.get() != null)
				intwEntity.setTech_id(techDetails.get());

			Interview savedRecord = interviewRepository.save(intwEntity);

			if (savedRecord != null)
				return "saved";
		}
		return null;
	}
	// HRMS-66 END
}
