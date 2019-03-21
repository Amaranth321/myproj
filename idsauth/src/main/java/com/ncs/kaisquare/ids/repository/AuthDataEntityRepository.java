package com.ncs.kaisquare.ids.repository;

import com.ncs.kaisquare.ids.entity.AuthDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDataEntityRepository extends MongoRepository<AuthDataEntity,String>{
    public AuthDataEntity findByUsername(String username);
}
