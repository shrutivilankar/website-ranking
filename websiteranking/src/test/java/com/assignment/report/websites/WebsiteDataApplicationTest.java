package com.assignment.report.websites;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.report.websites.repository.IWebsiteDataJpaRespoitory;
import com.assignment.report.websites.repository.models.WebsiteDataEntity;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = "application-test.properties")
@DataJpaTest(showSql = true)
public class WebsiteDataApplicationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	IWebsiteDataJpaRespoitory websiteDataJpaRepository;

	@Test
	public void whenfindByDate_thenReturnWebsiteData() {
		Date dateNow = new Date();
		WebsiteDataEntity webData = new WebsiteDataEntity("google.com", dateNow, 1111111);

		WebsiteDataEntity persistedEntity = entityManager.persist(webData);

		List<WebsiteDataEntity> found = websiteDataJpaRepository.findByDate(dateNow, new Sort(Sort.DEFAULT_DIRECTION,"id"));
		assertThat(persistedEntity, is(equalTo(found.get(0))));

	}

}
