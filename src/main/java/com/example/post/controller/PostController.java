package com.example.post.controller;

import com.example.post.dto.post.request.PatchRequest;
import com.example.post.dto.post.request.PostRequest;
import com.example.post.dto.post.response.PostResponse;
import com.example.post.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;
@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest)
    {
       return  ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postRequest));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(@RequestParam(defaultValue = "5",required = false) int pageSize ,@RequestParam(required = false,defaultValue = "0") int pageNumber
   ,@RequestParam(required = false ,defaultValue = "asc") String sortBy )
    {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts(pageNumber ,pageSize ,sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable String id)
    {
    return  ResponseEntity.status(HttpStatus.OK).body(postService.getPost(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id)
    {
      return     ResponseEntity.status(HttpStatus.NO_CONTENT).body(postService.deletePost(id));

    }

    @PutMapping("/{id}")

    public ResponseEntity<PostResponse> updatePost(@PathVariable String id, @RequestBody PatchRequest patchRequest)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(id,patchRequest));

    }


}
