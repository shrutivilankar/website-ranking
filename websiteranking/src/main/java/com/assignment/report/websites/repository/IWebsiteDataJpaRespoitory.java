package com.assignment.report.websites.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.report.websites.repository.models.WebsiteDataEntity;

/**
 * JPA repository for website data persistence operations
 * @author shruti
 */
@Repository
public interface IWebsiteDataJpaRespoitory extends JpaRepository<WebsiteDataEntity, Long> {
		
	/**
	 * This operation retrieves all website data that matches the passed parameters. 
	 * @param date Specific date for the websites data retrieval
	 * @param sort {@link Sort} defines order and columns to be sorted
	 * @return List of {@link WebsiteDataEntity}
	 */
	public List<WebsiteDataEntity>findByDate( Date date, Sort sort);
	

}
