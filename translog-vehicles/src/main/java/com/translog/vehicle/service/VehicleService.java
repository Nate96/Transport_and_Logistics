package com.translog.vehicle.service;

import java.util.List;

import com.translog.vehicle.dto.VehicleDTO;

public interface VehicleService {
    public String insertNewVehicle(VehicleDTO vehicleDTO);
    public List<VehicleDTO> fetchAvailableVehicles();
    public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName);
    public VehicleDTO fetchVehicleByVehicleNumber(String vehicleNumber);
    public String updateVehicleStatus(String vehicleNum, VehicleDTO dto);
    public String removeVehicle(String vehicleNum);
}
