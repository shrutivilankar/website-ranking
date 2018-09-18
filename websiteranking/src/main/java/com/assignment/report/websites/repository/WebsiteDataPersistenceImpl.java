package com.assignment.report.websites.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.assignment.report.websites.repository.models.WebsiteDataEntity;
import com.assignment.report.websites.services.models.WebsiteDataFilterCriteria;

public class WebsiteDataPersistenceImpl implements IWebsiteDataPersistence {

	private static final Logger log = LoggerFactory.getLogger(WebsiteDataPersistenceImpl.class);

	@Autowired
	IWebsiteDataJpaRespoitory jpaRepository;

	/**
	 * This method retrieves websites based on filter criteria. 
	 * Different repository queries are triggered based on presence of date criteria.
	 * Subset of results is created based on limit criteria  
	 */
	@Override
	public List<WebsiteDataEntity> retrieveRankedWebsites(WebsiteDataFilterCriteria filterData) {

		List<WebsiteDataEntity> websiteDataResults;

		if (filterData.getDate().isPresent()) {

			log.info("Repository call to findByDate, date: {}, sort order: {}, column to sort : {} ",
					filterData.getDate().get(), filterData.getOrder(), filterData.getColumnToSort());

			websiteDataResults = jpaRepository.findByDate(filterData.getDate().get(),
					new Sort(filterData.getOrder(), filterData.getColumnToSort()));

		} else {

			log.info("Repository call to findAll, sort order: {}, column to sort : {} ", filterData.getOrder(),
					filterData.getColumnToSort());

			websiteDataResults = jpaRepository.findAll(new Sort(filterData.getOrder(), filterData.getColumnToSort()));
		}
		
		if (websiteDataResults.size() >= filterData.getLimit())
			websiteDataResults = websiteDataResults.subList(0, filterData.getLimit());

		log.debug("Retrieved Data : {} ", websiteDataResults);

		return websiteDataResults;

	}

}
