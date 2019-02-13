package com.epam.spring.hometask.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import javax.annotation.Resource;

import com.epam.spring.hometask.dao.UserDao;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;


public class UserServiceImpl implements UserService
{
	@Resource(name = "userDaoImpl")
	private UserDao dao;

	@Override
	public User getUserByEmail(final String email)
	{
		return dao.getUserByEmail(email);
	}

	@Override
	public User save(final User object)
	{
		if (object.getId() != null)
		{
			object.setModified(LocalDateTime.of(LocalDate.now(), LocalTime.now().withNano(0)));
			dao.update(object);
		}
		else
		{
			dao.save(object);
		}

		return object;
	}

	@Override
	public void remove(final User object)
	{
		if (dao.getById(object.getId()) != null)
		{
			dao.remove(object);
		}
	}

	@Override
	public User getById(final Integer id)
	{
		return dao.getById(id);
	}

	@Override
	public Collection<User> getAll()
	{
		return dao.getAll();
	}
}
