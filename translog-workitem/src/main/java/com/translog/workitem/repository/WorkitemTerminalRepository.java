package com.translog.workitem.repository;

import com.translog.workitem.entity.WorkitemTerminal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkitemTerminalRepository<Harbor> extends JpaRepository<WorkitemTerminal, String> {
    
}
