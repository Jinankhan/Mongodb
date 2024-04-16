package com.example.post.repository;

import com.example.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PostRepository extends MongoRepository<Post , String> {
}
