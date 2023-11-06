package com.sparta.springintroductionpersonalassignment;

import com.sparta.springintroductionpersonalassignment.dto.PostRequestDto;
import com.sparta.springintroductionpersonalassignment.dto.PostResponseDto;
import com.sparta.springintroductionpersonalassignment.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post newPost = requestDto.toEntity();
        postRepository.save(newPost);

        return PostResponseDto.of(newPost);
    }

    public List<PostResponseDto> getPostList() {
        List<Post> posts = postRepository.findAllByOrderByCreatedDateDesc();

        List<PostResponseDto> responseDtoList = posts.stream().map(PostResponseDto::of).toList();
        return responseDtoList;
    }
}
