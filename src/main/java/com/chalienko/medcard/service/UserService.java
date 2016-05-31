package com.chalienko.medcard.service;

import com.chalienko.medcard.domain.model.User;
import com.chalienko.medcard.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 26.04.2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllDoctors() {
        return userRepository.getAllDoctors();
    }

    public User getByUserName(String username) {
        return userRepository.getByUserName(username);
    }

    public void insertUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    public List<User> getAllRegisters(){
        return userRepository.getAllRegisters();}
}
