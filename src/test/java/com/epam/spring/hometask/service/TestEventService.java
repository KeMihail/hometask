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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestEventService
{
	@Autowired
	private EventService service;
	private Event source;
	private Integer count_event;

	private static final String NAME = "film";
	private static final String NAME_ = "kino";
	private static final Double PRICE = 2.2;

	@Before
	public void setUp()
	{
		count_event = service.getAll().size();
		source = new Event();
		source.setName(NAME);
		source.setRating(EventRating.HIGH);
		source.setBasePrice(PRICE);
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

		// update:
		source.setName(NAME_);
		service.save(source);

		target = service.getById(source.getId());
		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(), target.getId());
		Assert.assertEquals(source.getBasePrice(), target.getBasePrice(), 0);
		Assert.assertEquals(source.getName(), target.getName());
		Assert.assertEquals(source.getRating(), target.getRating());

		// getByName:
		Assert.assertTrue(service.getByName(NAME).isEmpty());
		Assert.assertTrue(service.getByName(NAME_).contains(source));

		// getAll:
		Assert.assertEquals(++count_event, Integer.valueOf(service.getAll().size()));

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
