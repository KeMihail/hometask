package com.epam.spring.hometask.dao.hibernate;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.epam.spring.hometask.dao.AuditoriumDao;
import com.epam.spring.hometask.domain.Auditorium;


public class AuditoriumDaoImpl implements AuditoriumDao
{

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	static final Logger rootLogger = LogManager.getRootLogger();

	@Override
	public Auditorium getById(final Integer id)
	{

		Auditorium auditorium = null;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			auditorium = session.get(Auditorium.class, id);
			transaction.commit();
		}
		catch (Exception e)
		{
			rootLogger.error(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}

		return auditorium;
	}

	@Override
	public Collection<Auditorium> getAll()
	{
		Collection<Auditorium> auditoriums = null;
		Session session = null;
		try
		{
			session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			TypedQuery<Auditorium> query = session.createNamedQuery("auditorium.getAll", Auditorium.class);
			auditoriums = query.getResultList();
			transaction.commit();
		}
		catch (Exception e)
		{
			rootLogger.error(e.getMessage());
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return auditoriums;
	}
}
