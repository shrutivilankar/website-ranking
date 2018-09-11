package com.assignment.report.websites.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.report.websites.repository.IWebsiteDataPersistence;
import com.assignment.report.websites.resources.models.WebsiteData;
import com.assignment.report.websites.services.mappers.IWebsiteDataServiceMappers;
import com.assignment.report.websites.services.models.WebsiteDataFilterCriteria;

/**
 * Service defines logic for retrieval of website data
 * @author shruti
 *
 */
public class RetrieveWebsiteDataServiceImpl implements IRetrieveWebsiteDataService {

	@Autowired
	IWebsiteDataPersistence repository; 
	
	@Autowired
	IWebsiteDataServiceMappers mapper;
	
	
	@Override
	public List<WebsiteData> retrieveRankedWebsites(WebsiteDataFilterCriteria filterData) {
	
		List<com.assignment.report.websites.repository.models.WebsiteDataEntity> repoWebsite = repository.retrieveRankedWebsites(filterData);
		return mapper.mapWebsiteRepositoryModelToWebsiteResourceModel(repoWebsite);
	}

}
