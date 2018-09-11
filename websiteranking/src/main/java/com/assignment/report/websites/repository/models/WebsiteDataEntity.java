package com.assignment.report.websites.repository.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity Model that represents website data
 *  
 * @author shruti
 */
@Entity(name="website_data")
public class WebsiteDataEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String link;
	private Date date;
	private Integer noOfVisits;
	
	public WebsiteDataEntity() {
		super();
	}
	
	public WebsiteDataEntity(String link, Date date, Integer noOfVisits) {
		super();
		this.link = link;
		this.date = date;
		this.noOfVisits = noOfVisits;
	}
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
		return "WebsiteDataEntity [id=" + id + ", link=" + link + ", date=" + date + ", noOfVisits=" + noOfVisits + "]";
	}
	
}
