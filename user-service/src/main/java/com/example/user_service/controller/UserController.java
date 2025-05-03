package com.example.user_service.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.entity.User;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Operation(summary = "Get user")
	@GetMapping("/me")
	public User getCurrentUser(@AuthenticationPrincipal User user) {
		return user;
	}

}
