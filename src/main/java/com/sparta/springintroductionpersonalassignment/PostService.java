package com.sparta.springintroductionpersonalassignment;

import com.sparta.springintroductionpersonalassignment.dto.PostRequestDto;
import com.sparta.springintroductionpersonalassignment.dto.PostResponseDto;
import com.sparta.springintroductionpersonalassignment.dto.UserRequestDto;
import com.sparta.springintroductionpersonalassignment.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
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

    public PostResponseDto getPost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));

        return PostResponseDto.of(post);
    }

    @Transactional
    public PostResponseDto modifyPost(long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));

        if (!post.getPassword().equals(requestDto.getPassword())) throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        post.update(requestDto);

        return PostResponseDto.of(post);
    }

    @Transactional
    public void deletePost(long id, UserRequestDto userRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));

        if (!post.getUsername().equals(userRequestDto.getUsername()) || !post.getPassword().equals(userRequestDto.getPassword())) {
            throw new IllegalArgumentException("사용자 정보가 일치하지 않습니다.");
        }
        postRepository.deleteById(id);
    }
}
