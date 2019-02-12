package com.epam.spring.hometask.service;

import java.util.Collection;
import java.util.List;

import com.epam.spring.hometask.domain.Auditorium;
import com.sun.istack.internal.NotNull;


public interface AuditoriumService
{
	Auditorium getById(@NotNull final Integer id);

	@NotNull
	Collection<Auditorium> getAll();
}
