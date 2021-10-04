package com.translog.terminal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.translog.terminal.dto.TerminalDTO;
import com.translog.terminal.entity.Terminal;
import com.translog.terminal.exception.TerminalException;
import com.translog.terminal.repository.TerminalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalServiceImp implements TerminalService{

    @Autowired
    private TerminalRepository terminalRepository;

    @Override
    public List<TerminalDTO> fetchFTRTerminals() throws TerminalException {

        Iterable<Terminal> result = terminalRepository.findAll();
        List<TerminalDTO> terminalList = new ArrayList<TerminalDTO>();

        //check if empty
        if(!result.iterator().hasNext()) {
            throw new TerminalException("terminal.empty");
        }

        for(Terminal terminal: result) {
            terminalList.add(TerminalDTO.toDto(terminal));
        }

        return terminalList;
    }

    @Override
    public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalException {
        
        List<Terminal> result = terminalRepository.findByItemType(itemType);

        if(result.isEmpty())
            throw new TerminalException("terminal.itemtype.notFound");
        
        List<TerminalDTO> terminalDTOList = new ArrayList<TerminalDTO>();
        for(Terminal terminal : result){
            terminalDTOList.add(TerminalDTO.toDto(terminal));
        }

        return terminalDTOList;
    }

    @Override
    public TerminalDTO insertNewTerminal(TerminalDTO terminalDTO) {
        
        Terminal terminal = Terminal.toEntity(terminalDTO);
        terminalRepository.save(terminal);
        
        return TerminalDTO.toDto(terminal);
    }

    @Override
    public String updateTerminal(Integer terminalId, Integer newCapacity) throws TerminalException {

        Optional<Terminal> result = terminalRepository.findById(terminalId);
        Terminal terminal = result.orElseThrow(() -> new TerminalException("terminal.notFound"));

        if(terminal.getAvailableCapacity() < newCapacity)
            throw new TerminalException("terminal.capacity.failed");

        if(terminal.getAvailableCapacity() == newCapacity)
            terminal.setStatus("Unavailable");

        terminal.setCapacity(newCapacity);
        terminalRepository.save(terminal);

        return "Terminal capacity is successfully reduced for ID: " + terminalId;
    }

    @Override
    public TerminalDTO fetchFTRTerminalByTerminalId(Integer terminalId) throws TerminalException {

        Optional<Terminal> result = terminalRepository.findById(terminalId);
        Terminal terminal = result.orElseThrow(() -> new TerminalException("terminal.notFound"));

        return TerminalDTO.toDto(terminal);
    }

    @Override
    public String removeTerminal(Integer terminalId) throws TerminalException {
        
        Optional<Terminal> result = terminalRepository.findById(terminalId);
        Terminal terminal = result.orElseThrow(() -> new TerminalException("terminal.notFound"));

        terminalRepository.delete(terminal);
        
        return " Terminal details are deleted successfully.";
    }

    
}
