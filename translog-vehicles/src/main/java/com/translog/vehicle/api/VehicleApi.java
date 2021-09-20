package com.translog.vehicle.api;

import com.translog.vehicle.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Terminal")
public class VehicleApi {

    /**
     * If your posting something like JSON data representing the User class 
     * you can use the annotation @Valid in conjunction with @RequestBody to 
     * trigger validation of annotations such as the @NotNull you have on your 
     * age property. Then with BindingResult you can check if the entity/data 
     * has errors and handle accordingly.
     */
    @Autowired
    private VehicleService vehicleService;

}
