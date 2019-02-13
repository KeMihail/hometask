package com.epam.spring.hometask.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestEventService
{
	@Autowired
	private EventService service;
	@Autowired
	private AuditoriumService auditorium_service;

	private Event source;
	private Integer count_event;
	private Auditorium auditorium;

	private static final String NAME = "film";
	private static final String NAME_ = "kino";
	private static final Double PRICE = 2.2;

	@Before
	public void setUp()
	{
		count_event = service.getAll().size();

		// AuditoriumService not contains method save
		auditorium = new ArrayList<Auditorium>(auditorium_service.getAll()).get(0);
		source = new Event();
		source.setName(NAME);
		source.setRating(EventRating.HIGH);
		source.setBasePrice(PRICE);
		source.setAuditorium(auditorium);
		source.setCreated(LocalDateTime.of(LocalDate.now(), LocalTime.now().withNano(0)));

		service.save(source);
	}

	@Test
	public void test()
	{
		// getById:
		Event target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(), target.getId());
		Assert.assertEquals(source.getBasePrice(), target.getBasePrice(), 0);
		Assert.assertEquals(source.getName(), target.getName());
		Assert.assertEquals(source.getRating(), target.getRating());
		Assert.assertEquals(source.getCreated(), target.getCreated());

		// update:
		source.setName(NAME_);
		service.save(source);

		target = service.getById(source.getId());
		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(), target.getId());
		Assert.assertEquals(source.getBasePrice(), target.getBasePrice(), 0);
		Assert.assertEquals(source.getName(), target.getName());
		Assert.assertEquals(source.getRating(), target.getRating());
		Assert.assertEquals(source.getModified(), target.getModified());

		// getByName:
		Assert.assertTrue(service.getByName(NAME).isEmpty());
		Assert.assertTrue(service.getByName(NAME_).contains(source));

		// getAll:
		Assert.assertEquals(++count_event, Integer.valueOf(service.getAll().size()));

		Assert.assertEquals(auditorium, source.getAuditorium());

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
