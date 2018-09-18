package com.assignment.report.websites.resources;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.report.websites.resources.helpers.SortOptionsConverter;
import com.assignment.report.websites.resources.models.SortOptions;
import com.assignment.report.websites.resources.models.WebsiteData;
import com.assignment.report.websites.services.IRetrieveWebsiteDataService;
import com.assignment.report.websites.services.models.WebsiteDataFilterCriteria;

/**
 * This rest controller defines all rest operations on website data resource
 * 
 * @author shruti
 *
 */
@RestController
public class WebsiteDataResource {
	private static final Logger log = LoggerFactory.getLogger(WebsiteDataResource.class);
	private static final String DEFAULT_LIMIT = "5";

	@Autowired
	IRetrieveWebsiteDataService retrieveWebsiteDataService;

	@Autowired
	WebsiteDataFilterCriteria filterData;

	/**
	 * This method allows retrieval of resource website based on criteria specified
	 * as below param
	 * 
	 * @param date   Date must be of pattern "yyyy-MM-dd"
	 * @param limit  Integer
	 * @param sortBy SortBy must be of type {@link SortOptions}
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/websites")
	@CrossOrigin
	public List<WebsiteData> retrieveWebsites(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam(value = "limit", required = false, defaultValue = DEFAULT_LIMIT) Integer limit,
			@RequestParam(value = "sortBy", required = false, defaultValue = "MostVisits") SortOptions sortBy)
			throws ParseException {

		filterData.setDate(date);
		filterData.setLimit(limit);
		filterData.setSortBy(sortBy.getValue());
		log.info("Websites are requested for filter : {} ", filterData);

		List<WebsiteData> websites = retrieveWebsiteDataService.retrieveRankedWebsites(filterData);
		log.info("All websites retrieved for filterData {} ", websites);
		return websites;
	}

	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(SortOptions.class, new SortOptionsConverter());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus
	public void handleAllExceptions(Exception e, HttpServletResponse response) {
		response.addHeader("TraceId", MDC.get("X-B3-TraceId"));
		response.addHeader("Access-Control-Expose-Headers","TraceId");
		response.setStatus(response.getStatus());
		
	}
}
