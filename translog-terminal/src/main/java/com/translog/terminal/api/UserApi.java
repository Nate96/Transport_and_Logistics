package com.translog.terminal.api;

import com.translog.terminal.dto.TerminalDTO;
import com.translog.terminal.exception.TerminalException;
import com.translog.terminal.service.TerminalService;

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
    private TerminalService userService;

    @PostMapping
    public ResponseEntity<TerminalDTO> createUser(@RequestBody TerminalDTO userProfileDTO) {
        userService.createUser(userProfileDTO);
        
        return new ResponseEntity<TerminalDTO>(userProfileDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, TerminalDTO userDto) throws TerminalException {

        return new ResponseEntity<String>(userService.updateUser(userId, userDto), HttpStatus.OK);
    }

    @DeleteMapping(value ="/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) throws TerminalException {

        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{userId}")
    public ResponseEntity<TerminalDTO> getUser(@PathVariable int userId) throws TerminalException {

        return new ResponseEntity<TerminalDTO>(userService.getUser(userId), HttpStatus.OK);
    }

    // login
}
