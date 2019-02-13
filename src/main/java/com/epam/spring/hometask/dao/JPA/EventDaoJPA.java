package com.epam.spring.hometask.dao.JPA;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.epam.spring.hometask.dao.EventDao;
import com.epam.spring.hometask.domain.Event;


public class EventDaoJPA implements EventDao
{
	final EntityManager em = Persistence.createEntityManagerFactory("task").createEntityManager();

	@Override
	public Collection<Event> getByName(final String name)
	{
		return em.createNamedQuery("event.getByName", Event.class).getResultList();
	}

	@Override
	public Event save(final Event object)
	{
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void update(final Event object)
	{
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
	}

	@Override
	public void remove(final Event object)
	{
		em.getTransaction().begin();
		em.remove(getById(object.getId()));
		em.getTransaction().commit();
	}

	@Override
	public Event getById(final Integer id)
	{
		return em.find(Event.class, id);
	}

	@Override
	public Collection<Event> getAll()
	{
		return em.createNamedQuery("event.getAll", Event.class).getResultList();
	}
}
