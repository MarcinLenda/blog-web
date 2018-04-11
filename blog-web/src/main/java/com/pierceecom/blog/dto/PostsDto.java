package com.pierceecom.blog.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostsDto {

    private Long id;
    private String title;
    private String content;
}
