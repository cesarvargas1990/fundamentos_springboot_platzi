package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import com.fundamentosplatzi.springboot.fundamentos.usecase.CreateUserUseCase;
import com.fundamentosplatzi.springboot.fundamentos.usecase.CreateUserUseCaseImpl;
import com.fundamentosplatzi.springboot.fundamentos.usecase.DeleteUserUseCase;
import com.fundamentosplatzi.springboot.fundamentos.usecase.DeleteUserUseCaseImpl;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUserImpl;
import com.fundamentosplatzi.springboot.fundamentos.usecase.UpdateUseCase;
import com.fundamentosplatzi.springboot.fundamentos.usecase.UpdateUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
    @Bean
    CreateUserUseCase createUser (UserService userService) {
        return new CreateUserUseCaseImpl(userService);
    }
    @Bean
    UpdateUseCase updateUseCase (UserService userService) {
        return new UpdateUseCaseImpl(userService);
    }
    @Bean
    DeleteUserUseCase deleteUserUseCase (UserService userService) {
        return new DeleteUserUseCaseImpl(userService);
    }

}
