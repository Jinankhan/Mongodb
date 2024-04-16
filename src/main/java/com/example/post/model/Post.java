package com.example.post.model;



import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Document(collection = "post")


public class Post {
    @Id
    private String  postId;
    private  String content;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @DBRef
    User user;


}
