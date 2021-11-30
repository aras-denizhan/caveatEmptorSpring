package com.example.caveatemptorv2.service;

import com.example.caveatemptorv2.model.User;

import java.util.List;

public interface UserService {
    public User addNewUser(User user);
    public void updateUser(User user);
    public boolean deleteUser(Long id);
    public User getUserById(Long id);
    public User getUserByName(String name);
    public List<User> getAllUsers();
}
