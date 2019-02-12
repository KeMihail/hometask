package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.User;
import com.sun.istack.internal.NotNull;


public interface UserDao extends AbstractDomainObjectDao<User>
{
	User getUserByEmail(@NotNull final String email);
}
