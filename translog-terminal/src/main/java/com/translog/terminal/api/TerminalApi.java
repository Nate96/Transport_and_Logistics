package com.translog.terminal.api;

import java.util.List;

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
@RequestMapping(value = "Terminal")
public class TerminalApi {

    @Autowired
    private TerminalService terminalService;

    @GetMapping()
    public ResponseEntity<List<TerminalDTO>> fetchFTRTerminals() throws TerminalException {
        
        return new ResponseEntity<List<TerminalDTO>> (terminalService.fetchFTRTerminals(), HttpStatus.OK);
    }

    @GetMapping(value = "/{terminalId}")
    public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable String terminalId) throws TerminalException {

        return new ResponseEntity<TerminalDTO>(terminalService.fetchFTRTerminalByTerminalId(terminalId), HttpStatus.OK);
    }

    @GetMapping(value = "/fetchTerminalsByItemType/{itemType}")
    public 	ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(@PathVariable String itemType) throws TerminalException {

        return new ResponseEntity<List<TerminalDTO>>(terminalService.fetchTerminalsByItemType(itemType), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TerminalDTO> insertNewTerminal(@RequestBody TerminalDTO tDTO) {

        return new ResponseEntity<TerminalDTO>(terminalService.insertNewTerminal(tDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/{terminalId}/{newCapacity}")
    public ResponseEntity<String> updateTerminal(@PathVariable String terminalId, @PathVariable Integer newCapacity) throws TerminalException {

        return new ResponseEntity<String>(terminalService.updateTerminal(terminalId, newCapacity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{terminalId}")
    public ResponseEntity<String> removeTerminal(@PathVariable String terminalId) throws TerminalException {

        return new ResponseEntity<String>(terminalService.removeTerminal(terminalId), HttpStatus.OK);
    }

}
