package com.translog.vehicle.api;

import com.translog.vehicle.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Terminal")
public class TerminalApi {

    @Autowired
    private VehicleService terminalService;

}
