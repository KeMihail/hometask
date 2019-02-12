package com.epam.spring.hometask.dao.JPA;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.spring.hometask.dao.UserDao;
import com.epam.spring.hometask.domain.User;


public class UserDaoJPA implements UserDao
{
	final EntityManager em = Persistence.createEntityManagerFactory("task").createEntityManager();

	@Override
	public User getUserByEmail(final String email)
	{
		return em.createNamedQuery("getUserByEmail", User.class).setParameter("email", email).getSingleResult();
	}

	@Override
	public User save(final User object)
	{
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();

		return object;
	}

	@Override
	public void update(final User object)
	{
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
	}

	@Override
	public void remove(final User object)
	{
		em.getTransaction().begin();
		em.remove(getById(object.getId()));
		em.getTransaction().commit();
	}

	@Override
	public User getById(final Integer id)
	{
		return em.find(User.class, id);
	}

	@Override
	public Collection<User> getAll()
	{
		return em.createNamedQuery("User.getAll", User.class).getResultList();
	}
}
