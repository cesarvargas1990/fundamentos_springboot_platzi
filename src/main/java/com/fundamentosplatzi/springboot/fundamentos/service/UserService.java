package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser (User user, Long id) {
         return userRepository.findById(id).map(
                user1 -> {
                   user1.setEmail(user.getEmail());
                   user1.setBirthDate(user.getBirthDate());
                   user1.setName(user.getName());
                   return userRepository.save(user1);
                }
        ).get();
    }

    public void delete(Long id) {
         userRepository.deleteById(id);
    }

    public Page<User> userPageable (Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User> userPageable2 (Pageable pageable) {
        return userRepository.findAll(pageable).toList();
    }
}
