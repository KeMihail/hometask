package com.epam.spring.hometask.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ @NamedQuery(name = "getUserByEmail", query = "select u from User u where u.email =:email"),
		@NamedQuery(name = "user.getAll", query = "select u from User u") })
public class User extends DomainObject
{
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;

	@Column
	private LocalDateTime created;

	@Column
	private LocalDateTime modified;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Ticket> tickets;

	public User()
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

	public void setTickets(final List<Ticket> tickets)
	{
		this.tickets = tickets;
	}

	public List<Ticket> getTickets()
	{
		return tickets;
	}

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
