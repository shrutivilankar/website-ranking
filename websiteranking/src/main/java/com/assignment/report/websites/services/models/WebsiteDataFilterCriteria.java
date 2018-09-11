package com.assignment.report.websites.services.models;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * Defines filter criteria for retrieving Website data.
 * @author shruti
 *
 */
@Component
public class WebsiteDataFilterCriteria{
	private static final String VISIT = "visit";
	private static final String ASC = "asc";
	private Optional<Date> date = Optional.empty();
	private Integer limit;
	private String sortBy;
	private Sort.Direction order = Sort.Direction.DESC;
	private String columnToSort = "noOfVisits";

	public WebsiteDataFilterCriteria()
	{
		super();
	}
	public WebsiteDataFilterCriteria(Optional<Date> date, Integer limit, String sortBy) {
		super();
		this.date = date;
		this.limit = limit;
		this.sortBy = sortBy;
	}

	public Optional<Date> getDate() {
		return date;
	}

	public void setDate(Date date) {

		this.date = Optional.ofNullable(date);
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSortBy() {

		return sortBy;
	}

	/**
	 * Sort by filter criteria defines the direction of sort and the column to be sorted
	 * @param sortBy
	 */
	public void setSortBy(String sortBy) {
		if (sortBy.toLowerCase().contains(ASC)) {
			order = Sort.Direction.ASC;
		}
		if (sortBy.toLowerCase().contains(VISIT)) {
			columnToSort = "noOfVisits";
		}
		this.sortBy = sortBy;
	}

	public Sort.Direction getOrder() {
		return order;
	}

	public String getColumnToSort() {
		return columnToSort;
	}

	@Override
	public String toString() {
		return "FilterData [date=" + date + ", limit=" + limit + ", sortBy=" + sortBy + "]";
	}

}
