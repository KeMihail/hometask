package com.epam.spring.hometask.dao.hibernate;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.epam.spring.hometask.dao.TicketDao;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;


public class TicketDaoImpl implements TicketDao
{
	final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public Ticket save(final Ticket object)
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

			return object;
		}
	}

	@Override
	public void update(final Ticket object)
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
	public void remove(final Ticket object)
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
	public Ticket getById(final Integer id)
	{
		Session session = null;
		Ticket ticket = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			ticket = session.get(Ticket.class, id);
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
		return ticket;
	}

	@Override
	public Collection<Ticket> getAll()
	{
		Session session = null;
		List<Ticket> result = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<Ticket> query = session.createNamedQuery("ticket.getAll", Ticket.class);
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
