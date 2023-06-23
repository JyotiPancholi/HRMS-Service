package com.adt.hrms.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.PositionModel;
import com.adt.hrms.repository.PositionRepo;
import com.adt.hrms.service.PositionService;
import com.adt.hrms.ui.PositionDateConverter;
import com.adt.hrms.ui.PositionUIModel;
import com.adt.hrms.util.InMemoryMap;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepo positionRepo;

	@Override
	public String savePosition(PositionModel pm) {
		Optional<PositionModel> opt = positionRepo.findById(pm.getPositionId());
		if (opt.isPresent())
			return "Position with Id " + pm.getPositionId() + " is alredy avalable Pls Insert new ID....";
		return positionRepo.save(pm).getPositionId() + "Position is Saved";

	}

	@Override
	public List<PositionModel> getAllPosition() {
		List<PositionModel> list = positionRepo.findAll();
		return list;
	}

	@Override
	public PositionModel getPosition(Integer id) {
		Optional<PositionModel> opt = positionRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@Override
	public String updatePosition(PositionModel pm) {
		return positionRepo.save(pm).getPositionId() + "Position Updated Successfully";
	}

	@Override
	public List<PositionUIModel> getAllUIPosition() {
		List<PositionModel> poslist = getAllPosition();
		List<PositionUIModel> uiposlist = new ArrayList<PositionUIModel>();

		for (int i = 0; i < poslist.size(); i++) {
			PositionModel dpm = poslist.get(i);
			PositionUIModel obj = new PositionUIModel();
			obj.setId(dpm.getPositionId());
			obj.setExperienceInYear(dpm.getExperienceInYear());

			LocalDate date1 = dpm.getPositionOpenDate().toLocalDate();
			String positionopenstr = date1.toString();
			obj.setPositionOpenDate(positionopenstr);

			LocalDate date2 = dpm.getPositionCloseDate().toLocalDate();
			String positionclosestr = date2.toString();
			obj.setPositionCloseDate(positionclosestr);

			obj.setStatus(InMemoryMap.avstatusmap.get(dpm.getStatus()));
			obj.setPositionType(InMemoryMap.avpositiontypemap.get(dpm.getPositionType()));
			uiposlist.add(obj);

		}

		return uiposlist;

	}

	@Override
	public String savePositionNew(PositionDateConverter pdc) {
		PositionModel pm = new PositionModel();
		List<String> techlist = new ArrayList<>();
		List<String> tech = pdc.getTechStack();
		HashMap<String, String> map = InMemoryMap.avtechnologymap;
		for (String str : tech) {
			if (map.keySet().contains(str))
				techlist.add(str);

		}
		pm.setTechStack(techlist);
		pm.setPositionName(pdc.getPositionName());

	    SimpleDateFormat sdfForTime = new SimpleDateFormat("HH.mm.ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String str =  pdc.getPositionclosedate() + " " + sdfForTime.format(timestamp);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
		LocalDateTime posititonCloseDate = LocalDateTime.parse(str, formatter);
		pm.setPositionCloseDate(posititonCloseDate);

		LocalTime time1 = LocalTime.now();
		String str1 = pdc.getPositionopendate() + " " + sdfForTime.format(timestamp);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
		LocalDateTime positionOpenDate = LocalDateTime.parse(str1, formatter1);
		pm.setPositionOpenDate(positionOpenDate);

		pm.setExperienceInYear(pdc.getExperienceInYear());

		HashMap<String, String> statusmap = InMemoryMap.avstatusmap;
		String stat = pdc.getStatus();
		String mapStat = null;
		if (statusmap.keySet().contains(stat))
			mapStat = stat;
		pm.setStatus(mapStat);

		pm.setRemote(pdc.isRemote());

		String postype = pdc.getPositionType();
		String mappostype = null;
		HashMap<String, String> postypemap = InMemoryMap.avpositiontypemap;
		if (postypemap.keySet().contains(postype))
			mappostype = postype;
		pm.setPositionType(mappostype);

		pm.setVacancy(pdc.getVacancy());

		return positionRepo.save(pm).getPositionId() + " Position is Saved";
	}

	@Override
	public List<PositionDateConverter> getAllPositionNew() {
		List<PositionModel> pmlist = getAllPosition();
		List<PositionDateConverter> pdclist = new ArrayList<PositionDateConverter>();

		for (int i = 0; i < pmlist.size(); i++) {
			PositionModel pm = pmlist.get(i);
			PositionDateConverter obj = new PositionDateConverter();
			obj.setUiid(pm.getPositionId());
			obj.setPositionName(pm.getPositionName());
			obj.setTechStack(pm.getTechStack());
			obj.setStatus(pm.getStatus());
			obj.setExperienceInYear(pm.getExperienceInYear());
			obj.setRemote(pm.getRemote());
			obj.setPositionType(pm.getPositionType());
			obj.setVacancy(pm.getVacancy());

			LocalDate date1 = pm.getPositionOpenDate().toLocalDate();
			String positionopenstr = date1.toString();
			obj.setPositionopendate(positionopenstr);

			LocalDate date2 = pm.getPositionCloseDate().toLocalDate();
			String positionclosestr = date2.toString();
			obj.setPositionclosedate(positionclosestr);

			pdclist.add(obj);
		}
		return pdclist;
	}

	@Override
	public String updatePositionNew(Integer uiid, PositionDateConverter pdc) {
		Optional<PositionModel> opt = positionRepo.findById(pdc.getUiid());
		if (!opt.isPresent())
			return "Position not found with id: " + pdc.getUiid();
		else
			opt.get().setPositionName(pdc.getPositionName());

		List<String> techlist = new ArrayList<>();
		List<String> tech = pdc.getTechStack();
		HashMap<String, String> map = InMemoryMap.avtechnologymap;
		for (String str : tech) {
			if (map.keySet().contains(str))
				techlist.add(str);

		}
		opt.get().setTechStack(techlist);

		LocalTime time = LocalTime.now();
		String str = pdc.getPositionclosedate() + " " + String.valueOf(time);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime posititonCloseDate = LocalDateTime.parse(str, formatter);
		opt.get().setPositionCloseDate(posititonCloseDate);

		LocalTime time1 = LocalTime.now();
		String str1 = pdc.getPositionopendate() + " " + String.valueOf(time1);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime positionOpenDate = LocalDateTime.parse(str1, formatter1);
		opt.get().setPositionOpenDate(positionOpenDate);

		HashMap<String, String> statusmap = InMemoryMap.avstatusmap;
		String stat = pdc.getStatus();
		String mapStat = null;
		if (statusmap.keySet().contains(stat))
			mapStat = stat;
		opt.get().setStatus(mapStat);

		opt.get().setExperienceInYear(pdc.getExperienceInYear());
		opt.get().setRemote(pdc.isRemote());

		String postype = pdc.getPositionType();
		String mappostype = null;
		HashMap<String, String> postypemap = InMemoryMap.avpositiontypemap;
		if (postypemap.keySet().contains(postype))
			mappostype = postype;
		opt.get().setPositionType(mappostype);

		opt.get().setVacancy(pdc.getVacancy());

		return positionRepo.save(opt.get()).getPositionId() + " Positiion Updated Successfully";
	}

	@Override
	public String deletePositionNew(Integer positionId) {
		Optional<PositionModel> opt = positionRepo.findById(positionId);
		if (opt.isPresent()) {
			positionRepo.deleteById(positionId);
			return positionId + " has been Deleted";
		} else {
			return "Invalid Employe Id :: " + positionId;

		}
	}
}
