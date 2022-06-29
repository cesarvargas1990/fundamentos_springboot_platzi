package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PageableUserUseCase {
    Page<User> userPageable(Pageable pageable);
    List<User> userPageable2(Pageable pageable);
}
