package com.translog.workitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.workitem.dto.HarborDTO;

@Entity
@Table(name = "ftr_harbor")
public class Harbor {
    @Id
    private String country;
    private String availableHarborLocation;

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

    public String getAvailableHarborLocation() { return this.availableHarborLocation; }

    public void setAvailableHarborLocation(String availableHarborLocation) { this.availableHarborLocation = availableHarborLocation; }

    public static Harbor toEntity(HarborDTO harborDTO) {
        Harbor harbor = new Harbor();

        harbor.setAvailableHarborLocation(harborDTO.getAvailableHarborLocation());
        harbor.setCountry(harborDTO.getCountry());
        
        return harbor;
    }
    
}
