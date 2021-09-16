package com.translog.user.service;

import com.translog.user.dto.UserProfileDTO;
import com.translog.user.exception.UserException;

public interface UserService {
    public UserProfileDTO createUser(UserProfileDTO dto);
    public String updateUser(int userId, UserProfileDTO dto) throws UserException;
    public String deleteUser(int userId) throws UserException;
    public UserProfileDTO getUser(int userId) throws UserException;
    // TODO - create LoginDTO
    //public LoginDTO login(int userId, String password);
}