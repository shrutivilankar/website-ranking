package com.assignment.report.websites.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment.report.websites.repository.IWebsiteDataPersistence;
import com.assignment.report.websites.repository.WebsiteDataPersistenceImpl;

@Configuration
public class PersistenceLayerConfig {
	
	@Bean
	public IWebsiteDataPersistence websiteRankingRepository() {
		return new WebsiteDataPersistenceImpl();
	}

}
