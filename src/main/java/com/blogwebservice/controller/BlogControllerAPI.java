package com.blogwebservice.controller;

import com.blogwebservice.model.Blog;
import com.blogwebservice.repository.BlogRepository;
import com.blogwebservice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogControllerAPI {
    @Autowired
    IBlogService blogService;
    @GetMapping
    public ResponseEntity showAll(){
        return new ResponseEntity(blogService.showAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody Blog blog, @PathVariable Long id){
        blog.setId(id);
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id){
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/status/only-me/{id}")
    public ResponseEntity findByUserIdAndStatus(@PathVariable Long id){
        return new ResponseEntity<>(blogService.findByUserIdAndStatus(id, "only me"), HttpStatus.OK);
    }
    @GetMapping("/sort-by-likes-desc")
    public ResponseEntity findAllByLikeDesc(){
        return new ResponseEntity<>(blogService.findByStatusOrderByLikesDesc("public"), HttpStatus.OK);
    }
    @GetMapping("/top-4-by-likes")
    public ResponseEntity top4ByLikes(){
        return new ResponseEntity<>(blogService.findTop4ByOrderByLikesDesc("public"), HttpStatus.OK);
    }
}
