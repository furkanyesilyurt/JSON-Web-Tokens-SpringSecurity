package com.furkanyesilyurt.springbootsecurity.dao;

import com.furkanyesilyurt.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
