package com.epam.spring.hometask.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.hometask.domain.Ticket;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestTicketService
{
	@Autowired
	private TicketService service;

	private Ticket source;
	private Integer count_ticket;

	private static final Integer SEAT = 1;
	private static final Integer SEAT_ = 2;

	@Before
	public void setUp()
	{
		count_ticket = service.getAll().size();

		source = new Ticket();
		source.setSeat(SEAT);
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

		// update:
		source.setSeat(SEAT_);
		service.save(source);

		target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(), target.getId());
		Assert.assertEquals(source.getSeat(), target.getSeat());

		// getAll():
		Assert.assertEquals(++count_ticket, Integer.valueOf(service.getAll().size()));

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
