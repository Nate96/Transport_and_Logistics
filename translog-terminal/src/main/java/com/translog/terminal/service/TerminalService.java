package com.translog.terminal.service;

import java.util.List;

import com.translog.terminal.dto.TerminalDTO;
import com.translog.terminal.exception.TerminalException;

public interface TerminalService {
    public List<TerminalDTO> fetchFTRTerminals() throws TerminalException;
    public List<TerminalDTO>fetchTerminalsByItemType(String itemType) throws TerminalException;
    public TerminalDTO insertNewTerminal(TerminalDTO terminalDTO);
    public String updateTerminal(String terminalId, Integer newCapacity) throws TerminalException;
    public TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws TerminalException;
}
