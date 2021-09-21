package com.translog.workitem.repository;

import com.translog.workitem.entity.VehicleWorkitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleWorkitemRepository<Harbor> extends JpaRepository<VehicleWorkitem, String> {
    
}
