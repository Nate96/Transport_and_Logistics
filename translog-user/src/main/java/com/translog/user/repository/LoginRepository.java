package com.translog.user.repository;

import com.translog.user.entity.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> { }
