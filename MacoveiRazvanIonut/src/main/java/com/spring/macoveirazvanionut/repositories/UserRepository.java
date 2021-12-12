package com.spring.macoveirazvanionut.repositories;

import com.spring.macoveirazvanionut.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("SELECT u from User u where u.email=?1")
    User findUserByEmail(String email);
}
