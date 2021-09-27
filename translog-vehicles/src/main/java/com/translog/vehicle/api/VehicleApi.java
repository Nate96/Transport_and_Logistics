package com.translog.vehicle.api;

import java.util.List;

import javax.validation.Valid;

import com.translog.vehicle.dto.VehicleDTO;
import com.translog.vehicle.exception.VehicleException;
import com.translog.vehicle.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "vehicles")
public class VehicleApi {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<String> insertNewVehicle(@Valid @RequestBody VehicleDTO dto) throws VehicleException {

        return new ResponseEntity<String>(vehicleService.insertNewVehicle(dto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() {

        return new ResponseEntity<List<VehicleDTO>>(vehicleService.fetchAvailableVehicles(), HttpStatus.OK);
    }

    @GetMapping(value = "/managed-name/{vehicleName}")
    public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName) throws VehicleException {

        return new ResponseEntity<List<VehicleDTO>>(vehicleService.fetchVehicleDetailsByVehicleName(vehicleName), HttpStatus.OK);
    }

    @GetMapping(value = "/{vehicleNumber}")
    public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws VehicleException {

        return new ResponseEntity<VehicleDTO>(vehicleService.fetchVehicleByVehicleNumber(vehicleNumber), HttpStatus.OK);
    }

    @PutMapping(value = "/{vehicleNumber}")
    public ResponseEntity<String> updateVehicleStatus(@PathVariable String vehicleNum, @Valid VehicleDTO dto) throws VehicleException {

        return new ResponseEntity<String>(vehicleService.updateVehicleStatus(vehicleNum, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleNum}")
    public ResponseEntity<String> removeVehicle(@PathVariable String vehicleNum) throws VehicleException {

        return new ResponseEntity<String>(vehicleService.removeVehicle(vehicleNum), HttpStatus.OK);
    }

    // TODO - get vehicle by location

}
