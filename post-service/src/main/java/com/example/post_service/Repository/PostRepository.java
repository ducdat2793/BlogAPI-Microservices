package com.example.post_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.post_service.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	List<Post> findByUserId(Long userId);
}
