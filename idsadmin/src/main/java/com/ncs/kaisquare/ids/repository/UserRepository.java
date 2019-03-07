package com.ncs.kaisquare.ids.repository;

import com.ncs.kaisquare.ids.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>{

}
