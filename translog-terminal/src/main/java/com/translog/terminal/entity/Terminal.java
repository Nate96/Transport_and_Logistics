package com.translog.terminal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.terminal.dto.TerminalDTO;

@Entity
@Table(name= "ftr_terminals")
public class Terminal {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer terminalId;
   private String terminalName;
   private String country;
   private String itemType;
   private String terminalDescription;
   private Integer capacity;
   private Integer availableCapacity;
   private String status;
   private String harborLocation;

   public Integer getTerminalId() { return this.terminalId; }

   public void setTerminalId(Integer terminalId) { this.terminalId = terminalId; }

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

   public static Terminal toEntity(TerminalDTO terminalDto) {
    Terminal terminal = new Terminal();

    terminal.setAvailableCapacity(terminalDto.getAvailableCapacity());
    terminal.setCapacity(terminalDto.getCapacity());
    terminal.setCountry(terminalDto.getCountry());
    terminal.setHarborLocation(terminalDto.getHarborLocation());
    terminal.setItemType(terminalDto.getItemType());
    terminal.setStatus(terminalDto.getStatus());
    terminal.setTerminalDescription(terminalDto.getTerminalDescription());
    terminal.setTerminalId(terminalDto.getTerminalId());
    terminal.setTerminalName(terminalDto.getTerminalName());

    return terminal;
}

}
