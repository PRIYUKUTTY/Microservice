package com.jash.controller;

import com.jash.exception.UserException;
import com.jash.model.User;
import com.jash.repository.UserRepository;
import com.jash.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
// insert data
    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid  User user){
         User createdUser=userService.createUser(user);
         return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // data will be collect
    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) throws Exception {
          User user=userService.getUserId(id);
          return new ResponseEntity<>(user,HttpStatus.OK);
    }


    // update user details

   @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
       User updateUser=userService.updateUser(id,user);
       return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

    //delete user details throw user id

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws Exception {
         userService.deleteUser(id);
         return new ResponseEntity<>("User delete",HttpStatus.ACCEPTED);
    }
    


}
