package com.example.post.service.user;

import com.example.post.dto.user.request.UserRequest;
import com.example.post.dto.user.response.UserResponse;
import com.example.post.mapper.Mapper;
import com.example.post.model.User;
import com.example.post.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImp  implements  UserService{

    private  final Mapper mapper;
    private final UserRepository userRepository;
@Autowired
    public UserServiceImp(Mapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUserByEmail(String email) {

       User user = userRepository.findByEmail(email);
        System.out.println(user.getPosts());



        return mapper.convertEntityToDto(userRepository.findByEmail(email));
    }

    @Override
    public List<UserResponse> getUserAllUsers() {

        return userRepository.findAll().stream().map(mapper:: convertEntityToDto).toList();
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user= mapper.convertDtoToEntity(userRequest);
        return  mapper.convertEntityToDto(userRepository.save(user));

    }
}
