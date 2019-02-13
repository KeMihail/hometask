package com.epam.spring.hometask.dao;

import java.util.Collection;

import com.epam.spring.hometask.domain.Event;
import com.sun.istack.internal.NotNull;


public interface EventDao extends AbstractDomainObjectDao<Event>
{
	@NotNull
	Collection<Event> getByName(@NotNull final String name);
}
