package com.translog.vehicle.repository;

import com.translog.vehicle.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepository extends JpaRepository<Vehicle, String> { }
