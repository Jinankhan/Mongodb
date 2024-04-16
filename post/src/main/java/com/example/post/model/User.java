package com.example.post.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Getter
@Setter

public class User {

    @Id
    String id;
    String name;
    String email;
    @DBRef
    private List<Post> posts=new ArrayList<>();
}
