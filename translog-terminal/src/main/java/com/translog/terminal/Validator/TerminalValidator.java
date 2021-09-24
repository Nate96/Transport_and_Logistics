package com.translog.terminal.Validator;

import com.translog.terminal.dto.TerminalDTO;

public class TerminalValidator { 

    public Boolean validateTerminal(TerminalDTO terminalDTO) { 
        return validateStatus(terminalDTO.getStatus()); 
    }

    public Boolean validateStatus(String status) {

        return status.equals("Available") || status.equals("Not Available"); 
    }
    
}
