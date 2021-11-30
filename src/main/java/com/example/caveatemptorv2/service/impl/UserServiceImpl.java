package com.example.caveatemptorv2.service.impl;

import com.example.caveatemptorv2.model.User;
import com.example.caveatemptorv2.repository.UserRepository;
import com.example.caveatemptorv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByUserName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
