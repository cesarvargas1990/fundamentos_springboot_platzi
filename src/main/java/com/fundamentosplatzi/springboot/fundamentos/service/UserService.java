package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;
    @Transactional
    public void saveTransactional(List<User> users ) {
        users.stream().peek(user-> LOG.info("usuario insertado: "+ user))
                .forEach(user->userRepository.save(user));
    }

    public void saveNoTransactional(List<User> users ) {
        users.stream().peek(user-> LOG.info("usuario insertado: "+ user))
                .forEach(user->userRepository.save(user));
    }

    public List<User> getAllUsers () {
        return  userRepository.findAll();
    }
}
