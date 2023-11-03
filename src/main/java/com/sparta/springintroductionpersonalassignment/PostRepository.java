package com.sparta.springintroductionpersonalassignment;

import com.sparta.springintroductionpersonalassignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
