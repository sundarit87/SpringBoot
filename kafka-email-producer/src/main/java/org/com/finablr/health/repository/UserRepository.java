package org.com.finablr.health.repository;

import org.com.finablr.health.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

}