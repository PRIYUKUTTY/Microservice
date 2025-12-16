package com.jash.service;

import com.jash.exception.UserException;
import com.jash.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserId(Long id) throws UserException;
    List<User> getAllUsers();
    void deleteUser(Long id) throws UserException;
    User updateUser(Long id,User user) throws UserException;

}
