package com.translog.workitem.dto;

import com.translog.workitem.entity.Harbor;

public class HarborDTO {

    private String country;
    private String availableHarborLocation;

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

    public String getAvailableHarborLocation() { return this.availableHarborLocation; }

    public void setAvailableHarborLocation(String availableHarborLocation) { this.availableHarborLocation = availableHarborLocation; }

    public static HarborDTO toEntity(Harbor harbor) {
        HarborDTO dto = new HarborDTO();

        dto.setAvailableHarborLocation(harbor.getAvailableHarborLocation());
        dto.setCountry(harbor.getCountry());
        
        return dto;
    }
    
}
