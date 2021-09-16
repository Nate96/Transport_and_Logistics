package com.translog.terminal.service;

import com.translog.terminal.dto.TerminalDTO;
import com.translog.terminal.exception.UserException;

public interface UserService {
    public TerminalDTO createUser(TerminalDTO dto);
    public String updateUser(int userId, TerminalDTO dto) throws UserException;
    public String deleteUser(int userId) throws UserException;
    public TerminalDTO getUser(int userId) throws UserException;
    // TODO - create LoginDTO
    //public LoginDTO login(int userId, String password);
}
