package com.epam.spring.hometask.dao.JPA;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.epam.spring.hometask.dao.AuditoriumDao;
import com.epam.spring.hometask.domain.Auditorium;

@Repository
public class AuditoriumDaoJPA implements AuditoriumDao
{
	private EntityManager em = Persistence.createEntityManagerFactory("task").createEntityManager();

	@Override
	public Auditorium getById(final Integer id)
	{
		return em.find(Auditorium.class,id);
	}

	@Override
	public Collection<Auditorium> getAll()
	{
		TypedQuery<Auditorium> query = em.createNamedQuery("auditorium.getAll",Auditorium.class);
		return query.getResultList();
	}
}
