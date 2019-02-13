package com.epam.spring.hometask.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ @NamedQuery(name = "event.getAll", query = "select e from Event e"),
		@NamedQuery(name = "event.getByName", query = "select e from Event e where e.name =:name"),
		@NamedQuery(name = "event.getById", query = "select e from Event e where e.id =:id") })
public class Event extends DomainObject
{

	@Column
	private String name;
	@Column
	private double basePrice;
	@Column
	private EventRating rating;
	@Column
	private LocalDateTime created;
	@Column
	private LocalDateTime modified;

	@ManyToOne
	private Auditorium auditorium;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Ticket> tickets;

	public Event()
	{
	}

	public LocalDateTime getCreated()
	{
		return created;
	}

	public LocalDateTime getModified()
	{
		return modified;
	}

	public void setCreated(final LocalDateTime created)
	{
		this.created = created;
	}

	public void setModified(final LocalDateTime modified)
	{
		this.modified = modified;
	}

	public void setTickets(final Collection<Ticket> tickets)
	{
		this.tickets = tickets;
	}

	public Collection<Ticket> getTickets()
	{
		return tickets;
	}

	public void setAuditorium(final Auditorium auditorium)
	{
		this.auditorium = auditorium;
	}

	public Auditorium getAuditorium()
	{
		return auditorium;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setBasePrice(final double basePrice)
	{
		this.basePrice = basePrice;
	}

	public void setRating(final EventRating rating)
	{
		this.rating = rating;
	}

	public String getName()
	{
		return name;
	}

	public double getBasePrice()
	{
		return basePrice;
	}

	public EventRating getRating()
	{
		return rating;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(name);
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Event other = (Event) obj;
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}

}
