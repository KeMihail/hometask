package com.epam.spring.hometask.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	@Column
	private LocalDateTime created;
	@Column
	private LocalDateTime modified;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	public Ticket()
	{
	}

	public void setCreated(final LocalDateTime created)
	{
		this.created = created;
	}

	public void setModified(final LocalDateTime modified)
	{
		this.modified = modified;
	}

	public LocalDateTime getCreated()
	{
		return created;
	}

	public LocalDateTime getModified()
	{
		return modified;
	}

	public void setEvent(final Event event)
	{
		this.event = event;
	}

	public Event getEvent()
	{
		return event;
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
