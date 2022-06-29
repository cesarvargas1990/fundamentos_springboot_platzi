package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.usecase.CreateUserUseCase;
import com.fundamentosplatzi.springboot.fundamentos.usecase.DeleteUserUseCase;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.UpdateUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    public UserRestController(GetUser getUser,
                              CreateUserUseCase createUser,
                              UpdateUseCase updateUseCase,
                              DeleteUserUseCase deleteUserUseCase) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.updateUseCase = updateUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    private GetUser getUser;
    private CreateUserUseCase createUser;
    private UpdateUseCase updateUseCase;
    private DeleteUserUseCase deleteUserUseCase;

    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser (@RequestBody User newUser) {
        return  new ResponseEntity<>(createUser.createUser(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser (@RequestBody User newUser, @PathVariable Long id) {
        return  new ResponseEntity<>(updateUseCase.updateUser(newUser,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<User> deleteUser (@PathVariable Long id) {
        deleteUserUseCase.deleteUser(id);
        return  new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
 }
