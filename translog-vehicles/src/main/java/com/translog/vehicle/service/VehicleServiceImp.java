package com.translog.vehicle.service;

import java.util.List;

import com.translog.vehicle.dto.VehicleDTO;

import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImp implements VehicleService{

    /**
     * This method is used to insert the new vehicle details. 
     * Validate the inputs as per DTO and throw appropriate error message.
     */
    @Override
    public String insertNewVehicle(VehicleDTO vehicleDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return all vehicle details and if there are no vehicles available 
     * then throw VEHICLE_NOT_FOUND exception
     */
    @Override
    public List<VehicleDTO> fetchAvailableVehicles() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return the vehicle details based on the vehicletype and if there are no vehicles found 
     * then throw VEHICLE_NOT_FOUND exception
     */
    @Override
    public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return the vehicle details based on the vehiclenumber and 
     * if there are no vehicles found then throw VEHICLE_NOT_FOUND exception.
     */
    @Override
    public VehicleDTO fetchVehicleByVehicleNumber(String vehicleNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Check the the vehicle the available if not throw VEHICLE_NOT_FOUND exception. 
     * If the new status and the current status of the vehicle are same then throw 
     * VEHICLE_UPDATE_ALREADY_EXISTS exception else update the new status. Valid new 
     * status should be Active or Retired or Inprogress.
     */
    @Override
    public String updateVehicleStatus(String vehicleNum, VehicleDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    // To remove the given vehicle.
    @Override
    public String removeVehicle(String vehicleNum) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
