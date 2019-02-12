package com.epam.spring.hometask.dao;

import java.util.Collection;

import com.epam.spring.hometask.domain.Auditorium;
import com.sun.istack.internal.NotNull;


public interface AuditoriumDao
{
	Auditorium getById(@NotNull final Integer id);

	@NotNull
	Collection<Auditorium> getAll();
}
