package com.translog.vehicle.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.translog.vehicle.entity.Vehicle;

import java.util.Date;

public class VehicleDTO {

    @NotEmpty(message = "{vehicle.vehicleNumber.must}")
    // vehicle.vehicleNumber.invalid = Vehicle Number is not in valid format, please check
    private String vehicleNumber;

    @NotEmpty(message = "{vehicle.vehicleName.must}")
    @Size(max = 30, message = "{vehicle.vehicleName.invalid}")
    // TODO - validate string pattern
    private String vehicleName;

    @NotNull(message = "{vehicle.maxLiftingCapacity.must}")
    // TODO - validate is Integer
    private Integer maxLiftingCapacity;

    @NotNull(message = "{vehicle.retireDate.must}")
    private Date retireDate;

    @NotEmpty(message = "{vehicle.vehicleStatus.must}")
    // TODO - must be Active or Inprogress or Retired
    private String vehicleStatus;
    
    @Size(min = 5, max = 25, message = "String must have 5 - 25 characters")
    private String harborLocation;

    @Size(min = 5, max = 25, message = "String must have 5 - 25 characters")
    private String country;
 
    public String getVehicleNumber() { return this.vehicleNumber; }
 
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
 
    public String getVehicleName() { return this.vehicleName; }
 
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }
 
    public Integer getMaxLiftingCapacity() { return this.maxLiftingCapacity; }
 
    public void setMaxLiftingCapacity(Integer maxLiftingCapacity) { this.maxLiftingCapacity = maxLiftingCapacity; }
 
    public Date getRetireDate() { return this.retireDate; }
 
    public void setRetireDate(Date retireDate) { this.retireDate = retireDate; }
 
    public String getVehicleStatus() { return this.vehicleStatus; }
  
    public void setVehicleStatus(String vehicleStatus) { this.vehicleStatus = vehicleStatus; }
 
    public String getHarborLocation() { return this.harborLocation; }
 
    public void setHarborLocation(String harborLocation) { this.harborLocation = harborLocation; }
 
    public String getCountry() { return this.country; }
 
    public void setCountry(String country) { this.country = country; }

    public VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();

        dto.setCountry(vehicle.getCountry());
        dto.setHarborLocation(vehicle.getHarborLocation());
        dto.setMaxLiftingCapacity(vehicle.getMaxLiftingCapacity());
        dto.setRetireDate(vehicle.getRetireDate());
        dto.setVehicleName(vehicle.getVehicleName());
        dto.setVehicleNumber(vehicle.getVehicleNumber());
        dto.setVehicleStatus(vehicle.getVehicleStatus());

        return dto;
    }
}
