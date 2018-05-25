package com.codegym.ums.repository;

import com.codegym.ums.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findByFirstnameContaining(String firstname, Pageable pageable);
}
