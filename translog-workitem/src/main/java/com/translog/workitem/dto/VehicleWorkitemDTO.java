package com.translog.workitem.dto;

import com.translog.workitem.entity.VehicleWorkitem;

public class VehicleWorkitemDTO {

    private String workitemId;
    private String vehicleNumber;
    private String driverId;
    private String assignedWorkitemStatus;

    public String getWorkitemId() { return this.workitemId; }

    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public String getVehicleNumber() { return this.vehicleNumber; }

    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getDriverId() { return this.driverId; }

    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getAssignedWorkitemStatus() { return this.assignedWorkitemStatus; }

    public void setAssignedWorkitemStatus(String assignedWorkitemStatus) { this.assignedWorkitemStatus = assignedWorkitemStatus; }

    public static VehicleWorkitemDTO toDTO(VehicleWorkitem vehicleWorkitem) {
        VehicleWorkitemDTO dto = new VehicleWorkitemDTO();

        dto.setAssignedWorkitemStatus(vehicleWorkitem.getAssignedWorkitemStatus());
        dto.setDriverId(vehicleWorkitem.getDriverId());
        dto.setVehicleNumber(vehicleWorkitem.getVehicleNumber());
        dto.setWorkitemId(vehicleWorkitem.getWorkitemId());

        return dto;
    }

}
