package com.translog.vehicle.service;

import java.util.List;

import com.translog.vehicle.dto.VehicleDTO;
import com.translog.vehicle.entity.Vehicle;
import com.translog.vehicle.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImp implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public String insertNewVehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = Vehicle.toEntity(vehicleDTO);
        vehicleRepository.save(vehicle);

        return "Vehicle details are inserted successfully with vehicle number: " + vehicleDTO.getVehicleName();
    }

    /**
     * Return all vehicle details and if there are not vehicles available 
     * then throw VEHICLE_NOT_FOUND exception
     */
    @Override
    public List<VehicleDTO> fetchAvailableVehicles() {
        // TODO Auto-generated method stub
        List<Vehicle> availabVehicles = vehicleRepository.findByVehicleStatus("Active");
        
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
