package com.assignment.report.websites.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment.report.websites.services.IRetrieveWebsiteDataService;
import com.assignment.report.websites.services.RetrieveWebsiteDataServiceImpl;
import com.assignment.report.websites.services.mappers.IWebsiteDataServiceMappers;
import com.assignment.report.websites.services.mappers.WebsiteDataServiceMappersImpl;

@Configuration
public class ServicesLayerConfig {
	
	@Bean
	public IRetrieveWebsiteDataService websiteRankingService() {
		return new RetrieveWebsiteDataServiceImpl();
	}
	
	
	@Bean
	public IWebsiteDataServiceMappers websiteDataServiceMappers() {
		return new WebsiteDataServiceMappersImpl();
	}

}
