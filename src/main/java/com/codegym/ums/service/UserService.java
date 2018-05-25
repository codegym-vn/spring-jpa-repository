package com.codegym.ums.service;

import com.codegym.ums.model.User;

public interface UserService {

    User save(User user);

    User findById(Long id);

    Iterable<User> findAll();

    void delete(Long id);
}
