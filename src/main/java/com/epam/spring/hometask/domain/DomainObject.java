package com.epam.spring.hometask.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class DomainObject
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
}
