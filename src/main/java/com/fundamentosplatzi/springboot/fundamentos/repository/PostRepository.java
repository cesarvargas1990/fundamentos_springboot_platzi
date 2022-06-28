package com.fundamentosplatzi.springboot.fundamentos.repository;

import com.fundamentosplatzi.springboot.fundamentos.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Posts, Long> {
}
