package com.epam.spring.hometask.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.hometask.dao.AuditoriumDao;
import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.service.AuditoriumService;

@Service
public class AuditoriumServiceImpl implements AuditoriumService
{
	@Resource(name = "auditoriumDaoJPA")
	private AuditoriumDao dao;

	@Override
	public Auditorium getById(final Integer id)
	{
		return dao.getById(id);
	}

	@Override
	public Collection<Auditorium> getAll()
	{
		return dao.getAll();
	}
}
