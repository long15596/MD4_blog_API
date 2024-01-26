package com.blogwebservice.service;

import com.blogwebservice.model.Blog;
import com.blogwebservice.model.User;

import java.util.List;

public interface IBlogService extends IService<Blog>{
    List<Blog> findByUserIdAndStatus(Long id, String status);
    List<Blog> findByStatusOrderByLikesDesc(String status);
    List<Blog> findTop4ByOrderByLikesDesc(String status);
    List<Blog> showAllByUser(String username, String password);
}
