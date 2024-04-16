package com.example.post.service.post;

import com.example.post.dto.post.request.PatchRequest;
import com.example.post.dto.post.request.PostRequest;
import com.example.post.dto.post.response.PostResponse;
import com.example.post.mapper.Mapper;
import com.example.post.model.Post;
import com.example.post.model.User;
import com.example.post.repository.PostRepository;
import com.example.post.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements  PostService {

    private final PostRepository postRepository;
    private  final UserRepository userRepository;
   private final Mapper mapper;

   @Autowired
    public PostServiceImp(PostRepository postRepository, UserRepository userRepository, Mapper mapper) {
        this.postRepository = postRepository;
       this.userRepository = userRepository;
       this.mapper = mapper;
    }

    @Override
    public List<PostResponse> getAllPosts(int pageNumber, int pageSize, String sortBy) {
//       Pagination and sorting

        Pageable pageable= PageRequest.of(pageNumber ,pageSize).withSort(sortBy.toLowerCase().contains("asc")? Sort.Direction.ASC : Sort.Direction.DESC ,"content");

        return  postRepository.findAll(pageable).getContent().stream().map(mapper::convertEntityToDto).toList();
    }

    @Override
    public String deletePost(String  id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("id does not exist"));
        postRepository.delete(post);

        return "Delete Successfully";
    }

    @Override
    public PostResponse createPost(PostRequest postRequest) {
         Post post= mapper.convertDtoToEntity(postRequest);
         User user = userRepository.findById(postRequest.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
         post.setUser(user);
         Post savedPost=postRepository.save(post);
         List<Post> posts = user.getPosts();
         posts.add(savedPost);
         user.setPosts(posts);
         userRepository.save(user);
        return  mapper.convertEntityToDto(savedPost);
    }

    @Override
    public PostResponse getPost(String id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("id does not exist"));
        return mapper.convertEntityToDto(post);
    }

    @Override
    public PostResponse updatePost(String id, PatchRequest patchRequest) {
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("id does not exist"));
        post.setContent(patchRequest.getContent());
        return mapper.convertEntityToDto(postRepository.save(post));

    }
}
