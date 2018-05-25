package com.codegym.ums.service;

import com.codegym.ums.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface UserService {

    User save(User user);

    User findById(Long id);

    Iterable<User> findAll();

    void delete(Long id);

    Page<User> findByFirstname(String firstname, Pageable pageable);

    Iterable<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);
}
