package com.furkanyesilyurt.springbootsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserApp")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "ID_USER_SEQ")
    @GeneratedValue(generator = "generator", strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;

}
