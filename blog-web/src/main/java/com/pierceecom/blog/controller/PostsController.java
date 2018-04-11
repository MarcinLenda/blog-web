package com.pierceecom.blog.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pierceecom.blog.dto.PostsDto;
import com.pierceecom.blog.exception.PostsException;
import com.pierceecom.blog.model.Posts;
import com.pierceecom.blog.service.PostsService;

@RestController
@RequestMapping("/blog-web")
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(final PostsService postsService) {this.postsService = postsService;}

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public List<PostsDto> getAll() {

        return postsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsDto> get(@PathVariable final Long id) throws PostsException {
        final Optional<PostsDto> posts = postsService.findById(id);

        return posts.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/posts")
    public ResponseEntity<Long> save(@RequestBody final Posts posts) throws PostsException {
        final Long entityId = postsService.save(posts);
        final URI uri = ServletUriComponentsBuilder //
                .fromCurrentRequest().path("/posts") //
                .buildAndExpand(entityId) //
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody final Posts posts) throws PostsException {
        final Long entityId = postsService.update(posts);

        return ResponseEntity.ok(entityId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) throws PostsException {
        postsService.delete(id);

        return ResponseEntity.ok().build();
    }
}
