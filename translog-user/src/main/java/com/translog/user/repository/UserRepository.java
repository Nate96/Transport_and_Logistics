package com.translog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.translog.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> { }
