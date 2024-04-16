package com.example.post.service.user;

import com.example.post.dto.user.request.UserRequest;
import com.example.post.dto.user.response.UserResponse;
import java.util.List;

public interface UserService {
    UserResponse  getUserByEmail(String email);

    List<UserResponse> getUserAllUsers();

    UserResponse createUser(UserRequest userRequest);
}
