package com.pierceecom.blog.helper;

import org.springframework.stereotype.Component;

import com.pierceecom.blog.dto.PostsDto;
import com.pierceecom.blog.model.Posts;

@Component
public class PostsBaseConverter implements BaseConverter<Posts, PostsDto> {

    @Override
    public PostsDto convert(final Posts from) {
        return PostsDto.builder() //
                .id(from.getId()) //
                .title(from.getTitle()) //
                .content(from.getContent()) //
                .build();
    }
}
