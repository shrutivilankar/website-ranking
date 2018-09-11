package com.assignment.report.websites.services.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.assignment.report.websites.repository.models.WebsiteDataEntity;

public class WebsiteDataServiceMappersImpl implements IWebsiteDataServiceMappers{

	public List<com.assignment.report.websites.resources.models.WebsiteData> mapWebsiteRepositoryModelToWebsiteResourceModel(
			List<WebsiteDataEntity> repositoryWebsiteList) {

		List<com.assignment.report.websites.resources.models.WebsiteData> resourceWebsiteList = new ArrayList<>();
		
		repositoryWebsiteList.forEach( repositoryWebsite -> {
			
			com.assignment.report.websites.resources.models.WebsiteData resourceWebsite = new com.assignment.report.websites.resources.models.WebsiteData();
			resourceWebsite.setId(repositoryWebsite.getId());
			resourceWebsite.setDate(repositoryWebsite.getDate());
			resourceWebsite.setLink(repositoryWebsite.getLink());
			resourceWebsite.setNoOfVisits(repositoryWebsite.getNoOfVisits());
			resourceWebsiteList.add(resourceWebsite);
		});
		return resourceWebsiteList;

	}

}
