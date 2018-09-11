package com.assignment.report.websites.services.mappers;

import java.util.List;

import com.assignment.report.websites.repository.models.WebsiteDataEntity;

/**
 * 
 *Mapper to convert service layer model to repository layer model and viceversa
 *
 */
public interface IWebsiteDataServiceMappers {
	
	public List<com.assignment.report.websites.resources.models.WebsiteData> mapWebsiteRepositoryModelToWebsiteResourceModel(
			List<WebsiteDataEntity> repositoryWebsiteList);

}
