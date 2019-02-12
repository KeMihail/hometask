package com.epam.spring.hometask.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQuery(name = "auditorium.getAll",query = "select a from Auditorium a")
public class Auditorium extends DomainObject
{
	@Column
	private String name;

	@Column
	private Integer numberOfSeats;

	public Auditorium()
	{
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setNumberOfSeats(final Integer numberOfSeats)
	{
		this.numberOfSeats = numberOfSeats;
	}

	public String getName()
	{
		return name;
	}

	public Integer getNumberOfSeats()
	{
		return numberOfSeats;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Auditorium other = (Auditorium) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
