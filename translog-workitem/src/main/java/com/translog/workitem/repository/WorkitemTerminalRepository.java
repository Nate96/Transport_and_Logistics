package com.translog.workitem.repository;

import com.translog.workitem.entity.WorkitemTerminal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkitemTerminalRepository extends JpaRepository<WorkitemTerminal, String> {
    
}
