package com.translog.workitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.workitem.dto.VehicleWorkitemDTO;

@Entity
@Table(name = "ftr_vehicle_workItem")
public class VehicleWorkitem {
    @Id
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

    public static VehicleWorkitem toEntity(VehicleWorkitemDTO vehicleWorkitemDTO) {
        VehicleWorkitem vehicleWorkitem = new VehicleWorkitem();

        vehicleWorkitem.setAssignedWorkitemStatus(vehicleWorkitemDTO.getAssignedWorkitemStatus());
        vehicleWorkitem.setDriverId(vehicleWorkitemDTO.getDriverId());
        vehicleWorkitem.setVehicleNumber(vehicleWorkitemDTO.getVehicleNumber());
        vehicleWorkitem.setWorkitemId(vehicleWorkitemDTO.getWorkitemId());

        return vehicleWorkitem;
    }
    
}
