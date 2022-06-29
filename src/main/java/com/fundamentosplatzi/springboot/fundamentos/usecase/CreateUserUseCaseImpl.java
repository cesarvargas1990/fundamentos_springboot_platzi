package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserService userService;

    public CreateUserUseCaseImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User createUser(User user) {
       return this.userService.saveUser(user);
    }
}
