package com.ncs.kaisquare.ids.service;

import com.ncs.kaisquare.ids.repository.UserRepository;
import com.ncs.kaisquare.ids.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public void insertOne(User user){
        userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id).get();
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
