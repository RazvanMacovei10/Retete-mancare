package com.spring.macoveirazvanionut.repositories;

import com.spring.macoveirazvanionut.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
