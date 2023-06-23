package com.adt.hrms.service;

import java.util.List;

import com.adt.hrms.model.MasterAsset;

//JyotiPancholi - Jira no ->  HRMS-63(START)

public interface MasterAssetService {  
	
	public boolean saveMasterAsset(MasterAsset asset);

	public MasterAsset TakeAssetById(Integer id);
	
	//JyotiPancholi - Jira no ->  HRMS-83(START)
	public List<MasterAsset> SearchByAssetUser(String assetUser);

	public List<MasterAsset> SearchByStatus(String status);

	public List<MasterAsset> SearchByAssetType(String assetType);
	//JyotiPancholi - Jira no ->  HRMS-83(END)

}
//JyotiPancholi - Jira no ->  HRMS-63(END)
