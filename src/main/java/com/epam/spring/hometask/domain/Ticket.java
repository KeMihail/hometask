package com.epam.spring.hometask.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQuery(name = "ticket.getAll", query = "select t from Ticket as t")
public class Ticket extends DomainObject
{
	@Column
	private long seat;

	public Ticket()
	{
	}

	public void setSeat(final long seat)
	{
		this.seat = seat;
	}

	public long getSeat()
	{
		return seat;
	}
}
