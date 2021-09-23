package com.translog.workitem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;


import java.util.Date;
public class VehicleDTO {

    private String vehicleNumber;

    private String getVehicleId() { return this.vehicleNumber; }

    private void setVechicleId(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }


}
