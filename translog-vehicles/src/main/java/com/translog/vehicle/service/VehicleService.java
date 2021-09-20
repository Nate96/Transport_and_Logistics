package com.translog.vehicle.service;

import java.util.List;

import com.translog.vehicle.dto.VehicleDTO;
import com.translog.vehicle.exception.VehicleException;

public interface VehicleService {
    public String insertNewVehicle(VehicleDTO vehicleDTO);
    public List<VehicleDTO> fetchAvailableVehicles();
    public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException;
    public VehicleDTO fetchVehicleByVehicleNumber(String vehicleNumber) throws VehicleException;
    public String updateVehicleStatus(String vehicleNum, VehicleDTO dto) throws VehicleException;
    public String removeVehicle(String vehicleNum) throws VehicleException;
}
