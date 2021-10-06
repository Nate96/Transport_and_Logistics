package com.translog.vehicle.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.vehicle.dto.VehicleDTO;

@Entity
@Table(name= "ftr_vehicles")
public class Vehicle {
   @Id
   private String vehicleNumber;
   private String vehicleName;
   private Double maxLiftingCapacity;
   private Date retireDate;
   private String vehicleStatus;
   private String harborLocation;
   private String country;

   public String getVehicleNumber() { return this.vehicleNumber; }

   public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

   public String getVehicleName() { return this.vehicleName; }

   public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }

   public Double getMaxLiftingCapacity() { return this.maxLiftingCapacity; }

   public void setMaxLiftingCapacity(Double maxLiftingCapacity) { this.maxLiftingCapacity = maxLiftingCapacity; }

   public Date getRetireDate() { return this.retireDate; }

   public void setRetireDate(Date retireDate) { this.retireDate = retireDate; }

   public String getVehicleStatus() { return this.vehicleStatus; }
 
   public void setVehicleStatus(String vehicleStatus) { this.vehicleStatus = vehicleStatus; }

   public String getHarborLocation() { return this.harborLocation; }

   public void setHarborLocation(String harborLocation) { this.harborLocation = harborLocation; }

   public String getCountry() { return this.country; }

   public void setCountry(String country) { this.country = country; }


   public static Vehicle toEntity(VehicleDTO vehicleDTO) {
      Vehicle vehicle = new Vehicle();

      vehicle.setCountry(vehicleDTO.getCountry());
      vehicle.setHarborLocation(vehicleDTO.getHarborLocation());
      vehicle.setMaxLiftingCapacity(vehicleDTO.getMaxLiftingCapacity());
      vehicle.setRetireDate(vehicleDTO.getRetireDate());
      vehicle.setVehicleName(vehicleDTO.getVehicleName());
      vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
      vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());

      return vehicle;
  }


}
