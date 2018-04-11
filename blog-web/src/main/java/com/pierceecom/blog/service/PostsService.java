package com.pierceecom.blog.service;

import java.util.List;
import java.util.Optional;

import com.pierceecom.blog.dto.PostsDto;
import com.pierceecom.blog.exception.PostsException;
import com.pierceecom.blog.model.Posts;

public interface PostsService {

    Long save(Posts posts) throws PostsException;

    void delete(Long id) throws PostsException;

    Long update(Posts posts) throws PostsException;

    Optional<PostsDto> findById(Long id) throws PostsException;

    List<PostsDto> findAll();
}
