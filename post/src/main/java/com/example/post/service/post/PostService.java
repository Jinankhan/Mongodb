package com.example.post.service.post;

import com.example.post.dto.post.request.PatchRequest;
import com.example.post.dto.post.request.PostRequest;
import com.example.post.dto.post.response.PostResponse;
import java.util.List;


public interface PostService {

    List<PostResponse> getAllPosts(int pageNumber, int pageSize, String sortBy);
    String deletePost(String id);

    PostResponse createPost(PostRequest postRequest);

    PostResponse getPost(String id);


    PostResponse updatePost(String id, PatchRequest patchRequest);

}
