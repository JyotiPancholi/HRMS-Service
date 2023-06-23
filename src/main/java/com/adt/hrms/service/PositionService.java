package com.adt.hrms.service;

import java.util.List;

import com.adt.hrms.model.PositionModel;
import com.adt.hrms.ui.PositionDateConverter;

import com.adt.hrms.ui.PositionUIModel;

public interface PositionService {

	public List<PositionModel> getAllPosition();

	public PositionModel getPosition(Integer id);

	public String savePosition(PositionModel pm);

	public String updatePosition(PositionModel pm);

	public List<PositionUIModel> getAllUIPosition();

	public String savePositionNew(PositionDateConverter pdc);

	public List<PositionDateConverter> getAllPositionNew();

	public String updatePositionNew(Integer uiid, PositionDateConverter pdc);

	public String deletePositionNew(Integer positionId);

}
