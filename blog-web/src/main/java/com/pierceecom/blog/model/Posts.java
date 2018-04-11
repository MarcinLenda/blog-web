package com.pierceecom.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
}
