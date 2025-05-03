package com.example.post_service.service;

import org.springframework.stereotype.Service;

import com.example.post_service.dto.UserDto;
import com.example.post_service.feighClient.UserClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	
	 private final UserClient userClient;
	 
	 public UserDto getUserByUserClient() {
		 return userClient.getUser();
	 }
}
