package com.codegym.ums.repository;

import com.codegym.ums.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
