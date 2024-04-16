package com.example.post.dto.post.response;

import lombok.Data;
import java.util.Date;

@Data
public class PostResponse {
    String  postId;
    String content;
    Date createdAt;
    Date updatedAt;
}
