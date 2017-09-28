package com.miclip.repository;

import com.miclip.entity.Identity;

import java.util.Optional;
import java.util.Set;

public interface Repository<T extends Identity> {

    Optional<T> get(String id);

    Set<T> get();

    void persist(T entity);

    void remove(T entity);
}