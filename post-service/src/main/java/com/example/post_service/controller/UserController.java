package com.example.post_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post_service.dto.UserDto;
import com.example.post_service.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@Operation(summary = "Get user by feigh client")
	@GetMapping("/me")
	public UserDto getCurrentUser() {
		return userService.getUserByUserClient();
	}
}
