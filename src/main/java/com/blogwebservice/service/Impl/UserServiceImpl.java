package com.blogwebservice.service.Impl;

import com.blogwebservice.model.User;
import com.blogwebservice.repository.UserRepository;
import com.blogwebservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Iterable<User> showAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User checkLogin(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
