package com.translog.user.api;

import com.translog.user.dto.UserProfileDTO;

import javax.validation.Valid;

import com.translog.user.dto.LoginDTO;
import com.translog.user.exception.UserException;
import com.translog.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "UserProfile")
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserProfileDTO> createUser(@RequestBody @Valid UserProfileDTO userProfileDTO) {
        
        return new ResponseEntity<UserProfileDTO>(userService.createUser(userProfileDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody UserProfileDTO userDto) throws UserException {

        //TODO - validate incoming values

        return new ResponseEntity<String>(userService.updateUser(userId, userDto), HttpStatus.OK);
    }

    @DeleteMapping(value ="/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) throws UserException {

        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserProfileDTO> getUser(@PathVariable int userId) throws UserException {

        return new ResponseEntity<UserProfileDTO>(userService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO logindto) throws UserException {

        if(userService.login(logindto.getUserName(), logindto.getPassword()) == null)
            return new ResponseEntity<String>("Invalid username and password.", HttpStatus.OK);

        return new ResponseEntity<String>("Logged in successfully.", HttpStatus.OK);
    }
}
