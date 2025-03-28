package com.devpablo.workshopmongo.repository;

import com.devpablo.workshopmongo.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
