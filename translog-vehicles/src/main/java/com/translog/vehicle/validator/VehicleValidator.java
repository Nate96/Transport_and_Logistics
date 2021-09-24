package com.translog.vehicle.validator;

import com.translog.vehicle.dto.VehicleDTO;
import com.translog.vehicle.exception.VehicleException;


public class VehicleValidator {

    public Boolean validateVehicle(VehicleDTO dto) throws VehicleException {
        return isVehicleNameValid(dto.getVehicleName()) || isMaxLiftingCapacityValid(dto.getMaxLiftingCapacity().toString()) 
            || isVehicleStatusValid(dto.getVehicleStatus());
    }

    private Boolean isVehicleNameValid(String name) throws VehicleException {

        if(name.equals("Tower crane") || name.equals("FirePlace Crane") || name.equals("Double treadwheel Crane")
            || name.equals("Crawler Crane") || name.equals("Aerial Crane") || name.equals("Deck Crane"))
            return true;
        else
            throw new VehicleException("vehicle.vehicleName.invalid");
            
    }

    private Boolean isMaxLiftingCapacityValid(String maxLiftingCapacity) throws VehicleException {
		try {
		  Double.parseDouble(maxLiftingCapacity);
          return true;
		}
		catch(NumberFormatException e) {
		  //not a double
		  throw new VehicleException("vehicle.maxLiftingCapacity.invalid ");
		}
    }

    private Boolean isVehicleStatusValid(String status) throws VehicleException {
        
        if(status.equals("Active") || status.equals("Inprogress") || status.equals("Retired"))
            return false;
        else
            throw new VehicleException("vehicle.vehicleStatus.invalid");
            
    }
    
}
