package com.epam.spring.hometask.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ @NamedQuery(name = "getUserByEmail", query = "select u from User u where u.email =:email"),
		@NamedQuery(name = "user.getAll", query = "select u from User u"),@NamedQuery(name = "user",query = "") })
public class User extends DomainObject
{
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;

	/*//@ManyToMany
	private Set<Event> events = new HashSet<>();*/

	public User()
	{
	}

	/*public void setEvents(final Set<Event> events)
	{
		this.events = events;
	}

	public Set<Event> getEvents()
	{
		return events;
	}*/

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getEmail()
	{
		return email;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(firstName, lastName, email);
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
		User other = (User) obj;
		if (email == null)
		{
			if (other.email != null)
			{
				return false;
			}
		}
		else if (!email.equals(other.email))
		{
			return false;
		}
		if (firstName == null)
		{
			if (other.firstName != null)
			{
				return false;
			}
		}
		else if (!firstName.equals(other.firstName))
		{
			return false;
		}
		if (lastName == null)
		{
			if (other.lastName != null)
			{
				return false;
			}
		}
		else if (!lastName.equals(other.lastName))
		{
			return false;
		}
		return true;
	}

}
