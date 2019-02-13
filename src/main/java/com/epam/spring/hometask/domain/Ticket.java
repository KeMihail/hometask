package com.epam.spring.hometask.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQuery(name = "ticket.getAll", query = "select t from Ticket t")
public class Ticket extends DomainObject
{
	@Column
	private long seat;

	@ManyToOne
	private User user;

	public Ticket()
	{
	}

	public void setUser(final User user)
	{
		this.user = user;
	}

	public User getUser()
	{
		return user;
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
