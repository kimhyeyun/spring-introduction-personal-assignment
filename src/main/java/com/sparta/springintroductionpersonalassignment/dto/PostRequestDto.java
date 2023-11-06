package com.sparta.springintroductionpersonalassignment.dto;

import com.sparta.springintroductionpersonalassignment.entity.Post;
import lombok.Getter;

@Getter
public class PostRequestDto {

    private String title;
    private String content;
    private String username;
    private String password;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .username(username)
                .password(password)
                .build();
    }
}
