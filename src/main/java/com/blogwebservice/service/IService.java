package com.blogwebservice.service;

import java.util.Optional;

public interface IService<O> {
    Iterable<O> showAll();
    O save(O obj);
    Optional<O> findById(Long id);
    void remove(Long id);
}
