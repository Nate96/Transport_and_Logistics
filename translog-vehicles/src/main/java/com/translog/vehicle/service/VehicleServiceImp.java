package com.translog.vehicle.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import com.translog.vehicle.dto.VehicleDTO;
import com.translog.vehicle.entity.Vehicle;
import com.translog.vehicle.exception.VehicleException;
import com.translog.vehicle.repository.VehicleRepository;
import com.translog.vehicle.validator.VehicleValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImp implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleValidator vehicleValidator;

    @Override
    public String insertNewVehicle(VehicleDTO vehicleDTO) throws VehicleException {

        if(!vehicleValidator.validateVehicle(vehicleDTO))
            throw new ValidationException("Vehicle is not valid");
            
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

        List<Vehicle> availabVehicles = vehicleRepository.findByVehicleStatus("Active");
        if(availabVehicles.isEmpty())
            throw new ValidationException("VEHICLE_NOT_FOUND");
        
        List<VehicleDTO> availabVehiclesDTO = new ArrayList<VehicleDTO>();
        for(Vehicle vehicle : availabVehicles) {
            availabVehiclesDTO.add(VehicleDTO.toDTO(vehicle));
        }

        return availabVehiclesDTO;
    }

    /**
     * Return the vehicle details based on the vehicletype and if there are no vehicles found 
     * then throw VEHICLE_NOT_FOUND exception
     */
    @Override
    public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException {

        List<Vehicle> vehicleList = vehicleRepository.findByVehicleName(vehicleName);

        if(vehicleList.isEmpty())
            throw new ValidationException("VEHICLE_NOT_FOUND");
    
        List<VehicleDTO> VehicleDTOList = new ArrayList<VehicleDTO>();
        for(Vehicle vehicle : vehicleList) {
            VehicleDTOList.add(VehicleDTO.toDTO(vehicle));
        }

        return VehicleDTOList;
    }

    /**
     * Return the vehicle details based on the vehiclenumber and 
     * if there are no vehicles found then throw VEHICLE_NOT_FOUND exception.
     * @throws VehicleException
     */
    @Override
    public VehicleDTO fetchVehicleByVehicleNumber(String vehicleNumber) throws VehicleException {

        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if(vehicle == null)
            throw new VehicleException("VEHICLE_NOT_FOUND");

        return VehicleDTO.toDTO(vehicle);

    }

    /**
     * Check the the vehicle the available if not throw VEHICLE_NOT_FOUND exception. 
     * If the new status and the current status of the vehicle are same then throw 
     * VEHICLE_UPDATE_ALREADY_EXISTS exception else update the new status. Valid new 
     * status should be Active or Retired or Inprogress.
     * Success: {"Status of vehicleNumber :UE7890 updated successfully "} 
     * Fail: {"message": “Invalid Data”}
     * @throws VehicleException
     */
    @Override
    public String updateVehicleStatus(String vehicleNum, VehicleDTO dto) throws VehicleException {
        
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNum);

        if(vehicle == null) 
            throw new VehicleException("VEHICLE_NOT_FOUND");
        
        if(vehicle.getVehicleStatus().equals(dto.getVehicleStatus()))
            throw new VehicleException("VEHICLE_UPDATE_ALREADY_EXISTS ");
        
        vehicle.setVehicleStatus(dto.getVehicleStatus());
        vehicleRepository.save(vehicle);

        return "Tatus of vehicleNumber: " + dto.getVehicleName() + " updated successfully";

    }

    // To remove the given vehicle.
    @Override
    public String removeVehicle(String vehicleNum) throws VehicleException {
        
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNum);

        if(vehicle == null)
            throw new VehicleException("VEHICLE_NOT_FOUND");
        vehicleRepository.delete(vehicle);

        return "Terminal details are deleted successfully";

    }

    
}
