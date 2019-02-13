package com.epam.spring.hometask.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	private static Integer count_user;


	@Before
	public void setUp()
	{
		count_user = service.getAll().size();

		source = new User();
		source.setFirstName(USER_FIRST_NAME);
		source.setLastName(USER_LAST_NAME);
		source.setEmail(USER_EMAIL);

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

		// update:
		source.setEmail(USER_EMAIL_);

		service.save(source);

		target = service.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getEmail(), source.getEmail());
		Assert.assertEquals(target.getFirstName(), source.getFirstName());
		Assert.assertEquals(target.getLastName(), source.getLastName());

		// getUserByEmail:
		target = service.getUserByEmail(USER_EMAIL_);
		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getEmail(), source.getEmail());
		Assert.assertEquals(target.getFirstName(), source.getFirstName());
		Assert.assertEquals(target.getLastName(), source.getLastName());

		// getAll:
		Assert.assertEquals(++count_user,Integer.valueOf(service.getAll().size()));

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
