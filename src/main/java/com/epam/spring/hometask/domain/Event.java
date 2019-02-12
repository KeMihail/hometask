package com.epam.spring.hometask.domain;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;


public class Event extends DomainObject
{
	private String name;

	private double basePrice;

	private EventRating rating;

	public Event()
	{
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
	public int hashCode() {
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
		Event other = (Event) obj;
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
