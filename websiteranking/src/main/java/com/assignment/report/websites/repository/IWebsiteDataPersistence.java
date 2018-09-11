package com.assignment.report.websites.repository;

import java.util.List;

import com.assignment.report.websites.repository.models.WebsiteDataEntity;
import com.assignment.report.websites.services.models.WebsiteDataFilterCriteria;

/**
 * Repository interface for all website data related operations
 * 
 * @author shruti
 *
 */
public interface IWebsiteDataPersistence {
	
	/**
	 * Opertaion that retrieves websites based on filter criteria
	 * 
	 * @param filterData {@link WebsiteDataFilterCriteria}
	 * @return
	 */
	public List<WebsiteDataEntity> retrieveRankedWebsites(WebsiteDataFilterCriteria filterData);

}
