package com.translog.terminal.repository;

import java.util.List;

import com.translog.terminal.entity.Terminal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepository extends JpaRepository<Terminal, String> {
    public  List<Terminal> findByItemType(String itemType);
 }
