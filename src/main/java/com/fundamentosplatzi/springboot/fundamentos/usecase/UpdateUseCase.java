package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;

public interface UpdateUseCase {
    User updateUser(User user,Long id);


}
