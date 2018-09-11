package com.assignment.report.websites.resources.models;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data model for website data
 * 
 * @author shruti
 */
@Component
@Scope("prototype")
public class WebsiteData {
	
	private Long id;
	private String link;
	private Date date;
	private Integer noOfVisits;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNoOfVisits() {
		return noOfVisits;
	}
	public void setNoOfVisits(Integer noOfVisits) {
		this.noOfVisits = noOfVisits;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "WebsiteData [link=" + link + ", date=" + date + ", noOfVisits=" + noOfVisits + "]";
	}
}
