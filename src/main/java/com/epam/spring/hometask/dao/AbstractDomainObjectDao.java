package com.epam.spring.hometask.dao;

import java.util.Collection;

import com.epam.spring.hometask.domain.DomainObject;
import com.sun.istack.internal.NotNull;


public interface AbstractDomainObjectDao<T extends DomainObject>
{
	T save(@NotNull final T object);

	void update(@NotNull T object);

	void remove(@NotNull T object);

	T getById(@NotNull final Integer id);

	@NotNull
	Collection<T> getAll();
}
