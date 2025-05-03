package com.example.post_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post_service.dto.PostRequest;
import com.example.post_service.dto.PostResponse;
import com.example.post_service.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@Operation(summary = "Get all post")
	@GetMapping
	public ResponseEntity<List<PostResponse>> getAllPosts() {
		return ResponseEntity.ok(postService.getAllPosts());
	}

	@Operation(summary = "Create post")
	@PostMapping
	public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long userId = (Long) auth.getDetails();
		PostResponse response = postService.createPost(request, userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(summary = "Get post by user id")
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostResponse>> getPostsByUser(@PathVariable Long userId) {
		return ResponseEntity.ok(postService.getPostsByUser(userId));
	}
	
	@Operation(summary = "Get post by id")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponse> getPostsById(@PathVariable Long id) {
		return ResponseEntity.ok(postService.getPostById(id));
	}

	@Operation(summary = "Update post by id")
	@PutMapping("/{id}")
	public ResponseEntity<PostResponse> updateJob(@PathVariable Long id, @RequestBody PostRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long userId = (Long) auth.getDetails();
		PostResponse response = postService.updatePost(id, request, userId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "Delete post by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		postService.deletePost(id);
		return ResponseEntity.noContent().build(); // 204 No Content
	}

}
