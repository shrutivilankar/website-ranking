package com.assignment.report.websites.services;

import java.util.List;

import com.assignment.report.websites.resources.models.WebsiteData;
import com.assignment.report.websites.services.models.WebsiteDataFilterCriteria;

/**
 * Interface that defines operations to retrieve websites based on filter criteria
 * @see RetrieveWebsiteDataServiceImpl
 * @author shruti
 */
public interface IRetrieveWebsiteDataService {
	
	/**
	 * Operation to retrieve websites based on filter criteria 
	 */
	public List<WebsiteData> retrieveRankedWebsites(WebsiteDataFilterCriteria filterData);

}
