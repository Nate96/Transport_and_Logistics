package com.translog.user.service;

import java.util.Optional;

import com.translog.user.dto.UserProfileDTO;
import com.translog.user.entity.User;
import com.translog.user.exception.UserException;
import com.translog.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserProfileDTO createUser(UserProfileDTO dto) {
        User user = User.toEntity(dto);
        userRepository.save(user);
        return UserProfileDTO.toDto(user);
    }

    @Override
    public String updateUser(int userId, UserProfileDTO dto) throws UserException {
        // User user = userRepository.findById(userId).get();
        // if(user == null)
        //     return "No user with Id";

        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new UserException("user.notFound"));

        user.setMobileNumber(dto.getMobileNumber());
        user.setOfficeAddress(dto.getOfficeAddress());
        user.setPermanentAddress(dto.getPermanentAddress());

        userRepository.save(user);

        return "Mobile Number, Permanent Address, and Office Address are updated successfully for UserId: " + userId;
    }

    @Override
    public String deleteUser(int userId) throws UserException {

        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new UserException("user.notFound"));

        userRepository.delete(user);

        return "User " + userId + " details are removed successfully";
    }

    @Override
    public UserProfileDTO getUser(int userId) throws UserException {

        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new UserException("user.notFound"));
        
        return UserProfileDTO.toDto(user);
    }
    
}
