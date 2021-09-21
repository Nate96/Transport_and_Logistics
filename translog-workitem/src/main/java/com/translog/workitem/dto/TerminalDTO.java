package com.translog.workitem.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class TerminalDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String terminalId;

    @NotEmpty(message = "{terminal.terminalName.must}")
    @Size(min = 3, max = 20, message = "{terminal.terminalName.invalid}")
    private String terminalName;

    @NotEmpty(message = "{terminal.country.must}")
    @Size(min = 3, max = 20, message = "{terminal.country.invalid}")
    private String country;

    @NotEmpty(message = "{terminal.itemType.must}")
    @Size(min = 3, max = 30, message = "{terminal.itemType.invalid}")
    private String itemType;

    @NotEmpty(message = "{terminal.terminalDescription.must}")
    //TODO - pattern check
    private String terminalDescription;

    @NotNull(message = "{terminal.capacity.must}")
    @Max(value= 99999, message = "{terminal.capacity.invalid}")
    private Integer capacity;

    @NotNull(message = "{terminal.capacity.must}")
    @Max(value= 99999, message = "{terminal.capacity.invalid}")
    private Integer availableCapacity;

    @NotEmpty(message = "{terminal.status.must}")
    // TODO except only Available or Not Available
    private String status;
    private String harborLocation;

    public String getTerminalId() { return this.terminalId; }

    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }

    public String getTerminalName() { return this.terminalName; }

    public void setTerminalName(String terminalName) { this.terminalName = terminalName; }

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

    public String getItemType() { return this.itemType; }

    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getTerminalDescription() { return this.terminalDescription; }

    public void setTerminalDescription(String terminalDescription) { this.terminalDescription = terminalDescription; }

    public Integer getCapacity() { return this.capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getAvailableCapacity() { return this.availableCapacity; }

    public void setAvailableCapacity(Integer availableCapacity) { this.availableCapacity = availableCapacity; }

    public String getStatus() { return this.status; }

    public void setStatus(String status) { this.status = status; }

    public String getHarborLocation() { return this.harborLocation; }

    public void setHarborLocation(String harborLocation) { this.harborLocation = harborLocation; }
}
