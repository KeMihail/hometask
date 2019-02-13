package com.epam.spring.hometask.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import com.epam.spring.hometask.dao.UserDao;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;


public class UserServiceImpl implements UserService
{
	@Resource(name = "userDaoJPA")
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
			dao.update(object);
		}
		else
		{
			object.setId(dao.save(object).getId());
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
