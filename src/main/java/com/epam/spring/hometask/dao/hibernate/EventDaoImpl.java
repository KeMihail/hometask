package com.epam.spring.hometask.dao.hibernate;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.epam.spring.hometask.dao.EventDao;
import com.epam.spring.hometask.domain.Event;


public class EventDaoImpl implements EventDao
{
	final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public Collection<Event> getByName(final String name)
	{
		Session session = null;
		Collection<Event> result = null;
		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<Event> query = session.createNamedQuery("event.getByName", Event.class);
			query.setParameter("name", name);
			result = query.getResultList();
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}

			return result;
		}
	}

	@Override
	public Event save(final Event object)
	{
		Session session = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}

			return null;
		}
	}

	@Override
	public void update(final Event object)
	{
		Session session = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.update(object);
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
	}

	@Override
	public void remove(final Event object)
	{
		Session session = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.remove(object);
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
	}

	@Override
	public Event getById(final Integer id)
	{
		Session session = null;
		Event event = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<Event> query = session.createNamedQuery("event.getById", Event.class);
			query.setParameter("id", id);
			event = query.getSingleResult();
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return event;
	}

	@Override
	public Collection<Event> getAll()
	{
		Session session = null;
		Collection<Event> result = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<Event> query = session.createNamedQuery("event.getAll", Event.class);
			result = query.getResultList();
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}

		}
		return result;
	}
}
