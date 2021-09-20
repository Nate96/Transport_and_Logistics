package com.translog.vehicle.repository;

import java.util.List;

import com.translog.vehicle.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    public List<Vehicle> findByVehicleStatus(String vehicleStatus);
    public List<Vehicle> findByVehicleName(String vehicleName);
    public Vehicle findByVehicleNumber(String vehicleNumber);
 }
