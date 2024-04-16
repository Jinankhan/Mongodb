package com.example.post.repository;

import com.example.post.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository  extends MongoRepository<User ,String>{


//    Custom methods

    User findByEmail(String email);
}
