package com.sparta.springintroductionpersonalassignment.dto;

import com.sparta.springintroductionpersonalassignment.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostResponseDto {

    private String title;
    private String content;
    private String username;
    private LocalDateTime createdDate;

    public static PostResponseDto of(Post post) {
        return PostResponseDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .username(post.getUsername())
                .createdDate(post.getCreatedDate())
                .build();
    }
}
