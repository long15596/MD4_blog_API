package com.blogwebservice.controller;

import com.blogwebservice.model.User;
import com.blogwebservice.repository.BlogRepository;
import com.blogwebservice.service.IBlogService;
import com.blogwebservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserControllerAPI {
    @Autowired
    IUserService userService;
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity showAll(){
        return new ResponseEntity<>(userService.showAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("/login")
//    public ResponseEntity showAllBlog(String username, String password){
//        return new ResponseEntity<>(blogService.showAllByUser(username, password), HttpStatus.OK);
//    }
    @GetMapping("/login")
    public ResponseEntity checkLogin(String username, String password){
        return new ResponseEntity<>(userService.checkLogin(username, password), HttpStatus.OK);
    }
}
