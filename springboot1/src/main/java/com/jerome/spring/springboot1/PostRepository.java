package com.jerome.spring.springboot1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findById( int id );
    List<Post> findByTitle( String title );
    List<Post> findByContent(String content );
}