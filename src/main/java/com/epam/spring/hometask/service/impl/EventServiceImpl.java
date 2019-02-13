package com.epam.spring.hometask.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import com.epam.spring.hometask.dao.EventDao;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.service.EventService;


public class EventServiceImpl implements EventService
{
	@Resource(name = "eventDaoImpl")
	private EventDao dao;

	@Override
	public Collection<Event> getByName(final String name)
	{
		return dao.getByName(name);
	}

	@Override
	public Event save(final Event object)
	{
		if (object.getId() != null)
		{
			dao.update(object);
		}
		else
		{
			dao.save(object);
		}
		return object;
	}

	@Override
	public void remove(final Event object)
	{
		if (object.getId() != null)
		{
			dao.remove(object);
		}
	}

	@Override
	public Event getById(final Integer id)
	{
		return dao.getById(id);
	}

	@Override
	public Collection<Event> getAll()
	{
		return dao.getAll();
	}
}
