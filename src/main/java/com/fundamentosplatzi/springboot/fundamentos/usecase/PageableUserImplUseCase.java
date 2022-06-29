package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class PageableUserImplUseCase implements PageableUserUseCase {

    private UserService userService;

    public PageableUserImplUseCase(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page<User> userPageable(Pageable pageable) {
        return userService.userPageable(pageable);
    }

    @Override
    public List<User> userPageable2(Pageable pageable) {
        return userService.userPageable2(pageable);
    }
}
