package com.blogwebservice.service.Impl;

import com.blogwebservice.model.Blog;
import com.blogwebservice.model.User;
import com.blogwebservice.repository.BlogRepository;
import com.blogwebservice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public Iterable<Blog> showAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog save(Blog obj) {
        return blogRepository.save(obj);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByUserIdAndStatus(Long id, String status) {
        return blogRepository.findByUserIdAndStatus(id, status);
    }

    @Override
    public List<Blog> findByStatusOrderByLikesDesc(String status) {
        return blogRepository.findByStatusOrderByLikesDesc(status);
    }

    @Override
    public List<Blog> findTop4ByOrderByLikesDesc(String status) {
//        return blogRepository.findTop4ByOrderByLikesDesc();
        return blogRepository.findTop4ByStatusOrderByLikesDesc(status);
    }

    @Override
    public List<Blog> showAllByUser(String username, String password) {
        return blogRepository.findAllByUser(username, password);
    }
}
