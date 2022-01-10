package com.furkanyesilyurt.springbootsecurity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;

}
