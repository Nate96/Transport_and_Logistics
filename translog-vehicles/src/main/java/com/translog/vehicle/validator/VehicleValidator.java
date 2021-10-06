package com.translog.vehicle.validator;

import com.translog.vehicle.dto.VehicleDTO;
import com.translog.vehicle.exception.VehicleException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VehicleValidator {

    public Boolean validateVehicle(VehicleDTO dto) throws VehicleException {
        return isVehicleNameValid(dto.getVehicleName()) || isVehicleStatusValid(dto.getVehicleStatus())
            || isVehicleNumberValid(dto.getVehicleName());
    }

    private Boolean isVehicleNameValid(String name) throws VehicleException {

        if(name.equals("Tower crane") || name.equals("FirePlace Crane") || name.equals("Double treadwheel Crane")
            || name.equals("Crawler Crane") || name.equals("Aerial Crane") || name.equals("Deck Crane"))
            return true;
        else
            throw new VehicleException("vehicle.vehicleName.invalid");
            
    }

    public Boolean isVehicleStatusValid(String status) throws VehicleException {
        
        if(status.equals("Active") || status.equals("InProgress") || status.equals("Retired"))
            return false;
        else
            throw new VehicleException("vehicle.vehicleStatus.invalid");
            
    }

    private Boolean isVehicleNumberValid(String vehicleNumber) throws VehicleException {
        Pattern pattern = Pattern.compile("[A-Za-z]{2}[0-9]{6}");
        Matcher hasPattern = pattern.matcher(vehicleNumber);

        if(hasPattern.find())
            return true;
        
        throw new VehicleException("{vehicle.vehicleNumber.invalid}");
    }
    
}
