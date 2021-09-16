package com.translog.terminal.service;

import java.util.Optional;

import com.translog.terminal.dto.TerminalDTO;
import com.translog.terminal.entity.Terminal;
import com.translog.terminal.exception.UserException;
import com.translog.terminal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public TerminalDTO createUser(TerminalDTO dto) {
        Terminal user = Terminal.toEntity(dto);
        userRepository.save(user);
        return TerminalDTO.toDto(user);
    }

    @Override
    public String updateUser(int userId, TerminalDTO dto) throws UserException {
        // User user = userRepository.findById(userId).get();
        // if(user == null)
        //     return "No user with Id";

        Optional<Terminal> userOptional = userRepository.findById(userId);
        Terminal user = userOptional.orElseThrow(() -> new UserException("user.notFound"));

        user.setMobileNumber(dto.getMobileNumber());
        user.setOfficeAddress(dto.getOfficeAddress());
        user.setPermanentAddress(dto.getPermanentAddress());

        userRepository.save(user);

        return "Mobile Number, Permanent Address, and Office Address are updated successfully for UserId: " + userId;
    }

    @Override
    public String deleteUser(int userId) throws UserException {

        Optional<Terminal> userOptional = userRepository.findById(userId);
        Terminal user = userOptional.orElseThrow(() -> new UserException("user.notFound"));

        userRepository.delete(user);

        return "User " + userId + " details are removed successfully";
    }

    @Override
    public TerminalDTO getUser(int userId) throws UserException {

        Optional<Terminal> userOptional = userRepository.findById(userId);
        Terminal user = userOptional.orElseThrow(() -> new UserException("user.notFound"));
        
        return TerminalDTO.toDto(user);
    }
    
}
