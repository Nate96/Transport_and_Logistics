package com.translog.user.service;

import java.util.Optional;

import com.translog.user.dto.LoginDTO;
import com.translog.user.dto.UserProfileDTO;
import com.translog.user.entity.Login;
import com.translog.user.entity.User;
import com.translog.user.exception.UserException;
import com.translog.user.repository.LoginRepository;
import com.translog.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//TODO - improve error handling with messages
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserProfileDTO createUser(UserProfileDTO dto) {
        User user = User.toEntity(dto);
        userRepository.save(user);
        return UserProfileDTO.toDto(user);
    }

    @Override
    public String updateUser(int userId, UserProfileDTO dto) throws UserException {

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

    //check the user with the given credentials is available.
    @Override
    public LoginDTO login(int userId, String password) throws UserException {

        Optional<User> results = userRepository.findById(userId);
        User user = results.orElseThrow(() -> new UserException("user.notFound"));

        Optional<Login> loginOptional = loginRepository.findById(user.getEmailId());
        Login login = loginOptional.orElseThrow(() -> new UserException("no login found"));

        if(password == login.getPassword()) {
            LoginDTO dto = new LoginDTO();

            dto.setUserName(userId);
            dto.setPassword(password);

            return dto;
        }

        return null;
    }
    
}
