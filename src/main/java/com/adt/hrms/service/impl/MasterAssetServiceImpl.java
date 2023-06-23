package com.adt.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.hrms.model.MasterAsset;
import com.adt.hrms.repository.MasterAssetRepository;
import com.adt.hrms.service.MasterAssetService;

//JyotiPancholi - Jira no ->  HRMS-63(START)

@Service
public class MasterAssetServiceImpl implements MasterAssetService{

	@Autowired
	private MasterAssetRepository repo;
	
	@Override
	public boolean saveMasterAsset(MasterAsset asset) {
		MasterAsset masterasset = repo.save(asset);
		
		return masterasset!=null;
	}
	
	@Override
	public MasterAsset TakeAssetById(Integer id) {
		 Optional<MasterAsset> getById = repo.findById(id);
		return getById.get();
	}
	
	//JyotiPancholi - Jira no ->  HRMS-83(START)
	@Override
	public List<MasterAsset> SearchByAssetUser(String assetUser) {
		return repo.findByAssetUser(assetUser);
	}

	@Override
	public List<MasterAsset> SearchByStatus(String status) {
		return repo.findByStatus(status);
	}

	@Override
	public List<MasterAsset> SearchByAssetType(String assetType) {
		return repo.findByAssetType(assetType);
	}
	//JyotiPancholi - Jira no ->  HRMS-83(END)

}

//JyotiPancholi - Jira no ->  HRMS-63(END)
