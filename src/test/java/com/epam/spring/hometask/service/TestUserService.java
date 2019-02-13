package com.epam.spring.hometask.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestUserService
{
	@Autowired
	private UserService service;

	private User source;

	private static final String USER_FIRST_NAME = "mihail";
	private static final String USER_LAST_NAME = "keiko";
	private static final String USER_EMAIL = "mihaila@yandex.ru";
	private static final String USER_EMAIL_ = "mihail@yandex.ru";
	private static final Integer TICKET_SEAT = 10;

	private static Integer count_user;

	@Before
	public void setUp()
	{
		count_user = service.getAll().size();

		source = new User();
		source.setFirstName(USER_FIRST_NAME);
		source.setLastName(USER_LAST_NAME);
		source.setEmail(USER_EMAIL);
		source.setCreated(LocalDateTime.of(LocalDate.now(), LocalTime.now().withNano(0)));

		service.save(source);
	}

	@Test
	public void test()
	{

		// getById:
		User target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getEmail(), source.getEmail());
		Assert.assertEquals(target.getFirstName(), source.getFirstName());
		Assert.assertEquals(target.getLastName(), source.getLastName());
		Assert.assertEquals(target.getCreated(), source.getCreated());

		// update:
		source.setEmail(USER_EMAIL_);

		service.save(source);

		target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getEmail(), source.getEmail());
		Assert.assertEquals(target.getFirstName(), source.getFirstName());
		Assert.assertEquals(target.getLastName(), source.getLastName());
		Assert.assertEquals(target.getCreated(), source.getCreated());
		Assert.assertEquals(target.getModified(), source.getModified());

		// getUserByEmail:
		target = service.getUserByEmail(USER_EMAIL_);
		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getEmail(), source.getEmail());
		Assert.assertEquals(target.getFirstName(), source.getFirstName());
		Assert.assertEquals(target.getLastName(), source.getLastName());

		// getAll:
		Assert.assertEquals(++count_user, Integer.valueOf(service.getAll().size()));

		// remove:
		service.remove(source);
		Assert.assertNull(service.getById(source.getId()));
	}

	@After
	public void tearDown()
	{
		service.remove(source);
	}
}
