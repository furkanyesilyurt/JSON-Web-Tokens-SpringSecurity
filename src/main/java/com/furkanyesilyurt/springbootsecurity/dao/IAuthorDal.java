package com.furkanyesilyurt.springbootsecurity.dao;

import com.furkanyesilyurt.springbootsecurity.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthorDal extends JpaRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);
    void deleteByLastName(String lastName);
}
