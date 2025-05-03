package com.example.post_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.post_service.Repository.PostRepository;
import com.example.post_service.dto.PostRequest;
import com.example.post_service.dto.PostResponse;
import com.example.post_service.model.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	private final ModelMapper modelMapper;

	public PostResponse createPost(PostRequest request, Long userId) {
		Post post = modelMapper.map(request, Post.class);
		post.setCreatedDate(LocalDateTime.now());
		post.setUserId(userId);
		post = postRepository.save(post);
		return modelMapper.map(post, PostResponse.class);
	}

	public List<PostResponse> getAllPosts() {
		return postRepository.findAll().stream().map(post -> modelMapper.map(post, PostResponse.class))
				.collect(Collectors.toList());
	}

	public List<PostResponse> getPostsByUser(Long userId) {
		return postRepository.findByUserId(userId).stream().map(post -> modelMapper.map(post, PostResponse.class))
				.collect(Collectors.toList());
	}

	public PostResponse updatePost(Long id, PostRequest request, Long userId) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			post.get().setTitle(request.getTitle());
			post.get().setContent(request.getContent());
			post.get().setUserId(userId);
			post.get().setCreatedDate(LocalDateTime.now());
			postRepository.save(post.get());
			return modelMapper.map(post, PostResponse.class);
		} else {
			throw new RuntimeException("Job not found with id " + id);
		}

	}

	public PostResponse getPostById(Long id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			return modelMapper.map(post, PostResponse.class);
		} else {
			throw new RuntimeException("Job not found with id " + id);
		}
	}

	public void deletePost(Long id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			postRepository.deleteById(id);
		} else {
			throw new RuntimeException("Job not found with id " + id);
		}

	}

}
