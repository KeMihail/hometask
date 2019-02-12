package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.User;
import com.sun.istack.internal.NotNull;


public interface UserService extends AbstractDomainObjectService<User>
{
	User getUserByEmail(@NotNull final String email);
}
