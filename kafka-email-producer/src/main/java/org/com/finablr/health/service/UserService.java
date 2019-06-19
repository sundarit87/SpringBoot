package org.com.finablr.health.service;

import org.com.finablr.health.entity.User;

public interface UserService {

    User registerUser(User input);

    Iterable<User> findAll();
}
