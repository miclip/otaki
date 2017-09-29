package com.miclip.repository;

import com.miclip.entity.Identity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Repository<T extends Identity> {

    Set<T> get();

    default Set<T> get(Predicate<T> predicate) {
        return get()
                .stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }

    default Optional<T> get(String id) {
        return get()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    void persist(T entity);

    default void persist(T ... entities) {
        persist(Arrays.asList(entities));
    }

    default void persist(Collection<T> entities) {
        entities.forEach(this::persist);
    }

    void remove(T entity);

    default void remove(String id) {
        remove(entity -> entity.getId().equals(id));
    }

    default void remove(T ... entities) {
        remove(Arrays.asList(entities));
    }

    default void remove(Collection<T> entities) {
        entities.forEach(this::remove);
    }

    default void remove(Predicate<T> predicate) {
        get(predicate).forEach(this::remove);
    }
}