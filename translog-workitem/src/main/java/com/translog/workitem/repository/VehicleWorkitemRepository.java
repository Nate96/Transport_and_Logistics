package com.translog.workitem.repository;

import java.util.Optional;

import com.translog.workitem.entity.VehicleWorkitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleWorkitemRepository extends JpaRepository<VehicleWorkitem, String> {
    public Optional<VehicleWorkitem> findByVehicleNumber(String vehicleNumber);
    
}
