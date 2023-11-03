package com.sparta.springintroductionpersonalassignment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private String title;
    private String content;
    private String username;
    private LocalDateTime createdDate;
}
