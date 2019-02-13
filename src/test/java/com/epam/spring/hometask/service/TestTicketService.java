package com.epam.spring.hometask.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestTicketService
{

	@Autowired
	private TicketService service;
	@Autowired
	private UserService user_service;
	@Autowired
	private EventService event_service;

	private Event event;
	private User user;

	private Ticket source;
	private Integer count_ticket;

	private static final Integer SEAT = 1;
	private static final Integer SEAT_ = 2;
	private static final String USER_LAST_NAME = "mihail";
	private static final String USER_FIRST_NAME = "keiko";
	private static final String USER_EMAIL = "email@yandx.ru";
	private static final String EVENT_NAME = "film";
	private static final Double EVENT_PRICE = 2.2;

	@Before
	public void setUp()
	{

		count_ticket = service.getAll().size();

		event = new Event();
		event.setName(EVENT_NAME);
		event.setBasePrice(EVENT_PRICE);
		event.setRating(EventRating.LOW);
		event_service.save(event);

		user = new User();
		user.setLastName(USER_LAST_NAME);
		user.setFirstName(USER_FIRST_NAME);
		user.setEmail(USER_EMAIL);
		user_service.save(user);

		source = new Ticket();
		source.setSeat(SEAT);
		source.setUser(user);
		source.setEvent(event);
		service.save(source);
	}

	@Test
	public void test()
	{
		// getById:
		Ticket target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(), target.getId());
		Assert.assertEquals(source.getSeat(), target.getSeat());
		Assert.assertEquals(source.getUser(), target.getUser());
		Assert.assertEquals(source.getEvent(), target.getEvent());

		// update:
		source.setSeat(SEAT_);
		service.save(source);

		target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(), target.getId());
		Assert.assertEquals(source.getSeat(), target.getSeat());
		Assert.assertEquals(source.getUser(), target.getUser());
		Assert.assertEquals(source.getEvent(), target.getEvent());

		// getAll():
		Assert.assertEquals(++count_ticket, Integer.valueOf(service.getAll().size()));

		// remove:
		service.remove(source);

		Assert.assertNull(service.getById(source.getId()));
	}

	@After
	public void tearDown()
	{
		user_service.remove(user);
		event_service.remove(event);
		rootLogger.info("method tearDown");
	}
}
