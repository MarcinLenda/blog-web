package com.pierceecom.blog.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pierceecom.blog.model.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    Optional<Posts> findById(Long id);
}
