package com.epam.spring.hometask.domain;

import java.time.LocalDateTime;


public class Ticket extends DomainObject
{
	private User user;

	private Event event;

	private long seat;

	public Ticket()
	{
	}

	public void setUser(final User user)
	{
		this.user = user;
	}

	public void setEvent(final Event event)
	{
		this.event = event;
	}

	public void setSeat(final long seat)
	{
		this.seat = seat;
	}

	public User getUser()
	{
		return user;
	}

	public Event getEvent()
	{
		return event;
	}

	public long getSeat()
	{
		return seat;
	}
}
