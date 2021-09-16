package com.translog.terminal.repository;

import com.translog.terminal.entity.Terminal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Terminal, Integer> { }
