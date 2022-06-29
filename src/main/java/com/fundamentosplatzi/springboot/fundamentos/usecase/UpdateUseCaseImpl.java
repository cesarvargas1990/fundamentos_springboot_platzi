package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class UpdateUseCaseImpl implements UpdateUseCase{
    private UserService userService;

    public UpdateUseCaseImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User updateUser(User user, Long id) {
        return userService.updateUser(user,id);
    }


}
