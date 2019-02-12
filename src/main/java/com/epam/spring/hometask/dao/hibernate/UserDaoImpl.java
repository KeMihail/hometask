package com.epam.spring.hometask.dao.hibernate;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.epam.spring.hometask.dao.UserDao;
import com.epam.spring.hometask.domain.User;


public class UserDaoImpl implements UserDao
{
	final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public User getUserByEmail(final String email)
	{
		Session session = null;
		User user = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<User> query = session.createQuery("getUserByEmail", User.class);
			query.setParameter("email", email);
			user = query.getSingleResult();
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
			return user;
		}
	}

	@Override
	public User save(final User object)
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
		}
		return object;
	}

	@Override
	public void update(final User object)
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
	public void remove(final User object)
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
	public User getById(final Integer id)
	{
		Session session = null;
		User user = null;
		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			user = session.get(User.class, id);
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
		return user;
	}

	@Override
	public Collection<User> getAll()
	{
		Session session = null;
		Collection<User> users = null;

		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<User> query = session.createQuery("User.getAll", User.class);
			users = query.getResultList();
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
		return users;
	}
}
