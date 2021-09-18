package com.translog.workitem.api;

import com.translog.workitem.service.WotkitemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Terminal")
public class WorkitemApi {

    @Autowired
    private WotkitemService workitemService;

}
