package com.epam.spring.hometask.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import com.epam.spring.hometask.dao.TicketDao;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.service.AbstractDomainObjectService;
import com.epam.spring.hometask.service.TicketService;


public class TicketServiceImpl implements TicketService
{
	@Resource(name = "ticketDaoImpl")
	private TicketDao dao;

	@Override
	public Ticket save(final Ticket object)
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
	public void remove(final Ticket object)
	{
		if (dao.getById(object.getId()) != null)
		{
			dao.remove(object);
		}
	}

	@Override
	public Ticket getById(final Integer id)
	{
		return dao.getById(id);
	}

	@Override
	public Collection<Ticket> getAll()
	{
		return dao.getAll();
	}
}
