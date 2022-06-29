package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase{
    private UserService userService;

    public DeleteUserUseCaseImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void deleteUser(Long id) {
        userService.delete(id);
    }
}
