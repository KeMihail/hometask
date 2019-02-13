package com.epam.spring.hometask.service;

import java.util.Collection;
import java.util.List;

import com.epam.spring.hometask.domain.DomainObject;
import com.sun.istack.internal.NotNull;


public interface AbstractDomainObjectService<T extends DomainObject>
{
	T save(@NotNull final T object);

	void remove(@NotNull final T object);

	T getById(@NotNull final Integer id);

	@NotNull
	Collection<T> getAll();
}
