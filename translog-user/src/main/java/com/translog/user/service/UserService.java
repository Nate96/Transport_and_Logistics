package com.translog.user.service;

import com.translog.user.dto.UserProfileDTO;

public interface UserService {
    public UserProfileDTO createUser(UserProfileDTO dto);
    public String updateUser(int userId, UserProfileDTO dto);
    public String deleteUser(int userId);
    public UserProfileDTO getUser(int userId);
    // TODO - create LoginDTO
    //public LoginDTO login(int userId, String password);
}
