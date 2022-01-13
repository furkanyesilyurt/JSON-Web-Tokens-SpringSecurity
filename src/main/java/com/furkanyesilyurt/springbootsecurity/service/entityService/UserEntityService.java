package com.furkanyesilyurt.springbootsecurity.service.entityService;

import com.furkanyesilyurt.springbootsecurity.dao.IUserDao;
import com.furkanyesilyurt.springbootsecurity.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final IUserDao userDao;

    public User save(User user){
        return userDao.save(user);
    }

    public User findById(Long id){
        Optional<User> optionalUser = userDao.findById(id);
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return user;
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }



}
