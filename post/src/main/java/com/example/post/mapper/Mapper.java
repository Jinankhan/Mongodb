package com.example.post.mapper;

import com.example.post.dto.post.request.PostRequest;
import com.example.post.dto.post.response.PostResponse;
import com.example.post.dto.user.request.UserRequest;
import com.example.post.dto.user.response.UserResponse;
import com.example.post.model.Post;
import com.example.post.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    private final ModelMapper modelMapper;

    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PostResponse convertEntityToDto(Post post)
    {
      return  modelMapper.map(post,PostResponse.class);
    }

    public Post convertDtoToEntity(PostRequest postRequest)
    {
        return modelMapper.map(postRequest,Post.class);
    }



    public UserResponse  convertEntityToDto(User user)
    {
        return  modelMapper.map(user,UserResponse.class);
    }

    public User  convertDtoToEntity(UserRequest userRequest)
    {
        return modelMapper.map(userRequest,User.class);
    }


}
