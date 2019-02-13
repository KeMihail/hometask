package com.epam.spring.hometask.dao.JPA;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.spring.hometask.dao.TicketDao;
import com.epam.spring.hometask.domain.Ticket;


public class TicketDaoJPA implements TicketDao
{
	final EntityManager em = Persistence.createEntityManagerFactory("task").createEntityManager();

	@Override
	public Ticket save(final Ticket object)
	{
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();

		return object;
	}

	@Override
	public void update(final Ticket object)
	{
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
	}

	@Override
	public void remove(final Ticket object)
	{
		em.getTransaction().begin();
		em.remove(getById(object.getId()));
		em.getTransaction().commit();
	}

	@Override
	public Ticket getById(final Integer id)
	{
		return em.find(Ticket.class, id);
	}

	@Override
	public Collection<Ticket> getAll()
	{
		return em.createNamedQuery("ticket.getAll", Ticket.class).getResultList();
	}
}
