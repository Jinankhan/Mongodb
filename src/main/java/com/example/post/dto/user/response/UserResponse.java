package com.example.post.dto.user.response;

import com.example.post.dto.post.response.PostResponse;
import lombok.Data;
import java.util.List;

@Data
public class UserResponse {

    String id;
    String name;
    String email;
    List<PostResponse> posts;
}
