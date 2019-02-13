package com.epam.spring.hometask.service;

import java.util.Collection;

import com.epam.spring.hometask.domain.Event;
import com.sun.istack.internal.NotNull;


public interface EventService extends AbstractDomainObjectService<Event>
{
	@NotNull
	Collection<Event> getByName(@NotNull final String name);
}
