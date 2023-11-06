package com.sparta.springintroductionpersonalassignment;

import com.sparta.springintroductionpersonalassignment.dto.PostRequestDto;
import com.sparta.springintroductionpersonalassignment.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPostList() {
        return postService.getPostList();
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable long id) {
        return postService.getPost(id);
    }
}
