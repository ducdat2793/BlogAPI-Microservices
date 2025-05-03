package com.example.post_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

	private Long id;
    private String title;
    private String content;
    private Long userId;
    private LocalDateTime createdDate;
    
}
