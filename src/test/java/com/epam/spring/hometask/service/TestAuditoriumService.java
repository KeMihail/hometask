package com.epam.spring.hometask.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.hometask.domain.Auditorium;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestAuditoriumService
{
	@Autowired
	private AuditoriumService service;

	private static final Integer COUNT_AUD = Integer.valueOf(3);

	private static final String NAME_RED = "RED_AUD";
	private static final String NAME_GREEN = "GREEN_AUD";
	private static final String NAME_YELLOW = "YELLOW_AUD";

	private static final Integer ID_RED = Integer.valueOf(1);
	private static final Integer ID_GREEN = Integer.valueOf(2);
	private static final Integer ID_YELLOW = Integer.valueOf(3);

	private static final Integer NAME_OF_SEATS_RED = Integer.valueOf(100);
	private static final Integer NAME_OF_SEATS_GREEN = Integer.valueOf(200);
	private static final Integer NAME_OF_SEATS_YELLOW = Integer.valueOf(300);


	@Test
	public void test(){

		final Auditorium red_aud = service.getById(ID_RED);
		Assert.assertNotNull(red_aud);

		Assert.assertEquals(red_aud.getId(),ID_RED);
		Assert.assertEquals(red_aud.getName(),NAME_RED);
		Assert.assertEquals(red_aud.getNumberOfSeats(),NAME_OF_SEATS_RED);

		final Auditorium green_aud = service.getById(ID_GREEN);
		Assert.assertNotNull(green_aud);

		Assert.assertEquals(green_aud.getId(),ID_GREEN);
		Assert.assertEquals(green_aud.getName(),NAME_GREEN);
		Assert.assertEquals(green_aud.getNumberOfSeats(),NAME_OF_SEATS_GREEN);

		final Auditorium yellow_aud = service.getById(ID_YELLOW);
		Assert.assertNotNull(yellow_aud);

		Assert.assertEquals(yellow_aud.getId(),ID_YELLOW);
		Assert.assertEquals(yellow_aud.getName(),NAME_YELLOW);
		Assert.assertEquals(yellow_aud.getNumberOfSeats(),NAME_OF_SEATS_YELLOW);

		final Collection<Auditorium> auditoriums = service.getAll();

		Assert.assertNotNull(auditoriums);
		Assert.assertEquals(Integer.valueOf(auditoriums.size()),COUNT_AUD);
	}
}
