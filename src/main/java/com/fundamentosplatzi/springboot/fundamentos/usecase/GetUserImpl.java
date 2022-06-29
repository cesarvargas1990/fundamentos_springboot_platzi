package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImpl implements GetUser{
    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
