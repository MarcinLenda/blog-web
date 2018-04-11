package com.pierceecom.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pierceecom.blog.dto.PostsDto;
import com.pierceecom.blog.exception.PostsException;
import com.pierceecom.blog.helper.BaseConverter;
import com.pierceecom.blog.model.Posts;
import com.pierceecom.blog.repository.PostsRepository;

@Service
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final BaseConverter<Posts, PostsDto> postsBaseConverter;

    @Autowired
    public PostsServiceImpl(final PostsRepository postsRepository, final BaseConverter<Posts, PostsDto> postsBaseConverter) {
        this.postsRepository = postsRepository;
        this.postsBaseConverter = postsBaseConverter;
    }

    @Override
    public Long save(final Posts posts) throws PostsException {
        final Posts saveEntity = postsRepository.save(posts);

        return Optional.ofNullable(saveEntity).map(Posts::getId).orElseThrow(
                () -> PostsException.create("Save posts about id:" + posts.getId() + " failed.", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public void delete(final Long id) throws PostsException {
        final Optional<Posts> posts = postsRepository.findById(id);

        posts.map(p -> {
            postsRepository.delete(p);
            return true;
        }).orElseThrow(() -> PostsException.create("Delete posts about id: " + id + " failed.", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public Long update(final Posts posts) throws PostsException {
        final Posts saveEntity = postsRepository.save(posts);

        return Optional.ofNullable(saveEntity).map(Posts::getId).orElseThrow(
                () -> PostsException.create("Update posts about id:" + posts.getId() + " failed.", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public Optional<PostsDto> findById(final Long id) throws PostsException {
        return Optional.ofNullable(postsRepository.findById(id) //
                .map(postsBaseConverter::convert)
                .orElseThrow(() -> PostsException.create("Posts about id:" + id + " not found.", HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<PostsDto> findAll() {
        return postsRepository.findAll().stream() //
                .map(postsBaseConverter::convert) //
                .collect(Collectors.toList());
    }
}
