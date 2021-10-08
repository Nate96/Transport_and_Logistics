package com.translog.workitem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.workitem.dto.WorkitemDTO;

@Entity
@Table(name= "ftr_workitems")
public class Workitem {
   @Id
   private Long userId;
   private String workitemId;
   private String itemName;
   private String itemType;
   private String itemDescription;
   private String messageToRecipient;
   private String quantity;
   private String sourceCountry;
   private String destinationCountry;
   private String originHorborLocation;
   private String selectedHarborLocation;
   private Date shippingDate;
   private Integer amount;

   public String getWorkitemId() { return this.workitemId; }

   public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

   public Long getUserId() { return this.userId; }

   public void setUserId(Long userId) { this.userId = userId; }

   public String getItemName() { return this.itemName; }

   public void setItemName(String itemName) { this.itemName = itemName; }

   public String getItemType() { return this.itemType; }

   public void setItemType(String itemType) { this.itemType = itemType; }

   public String getItemDescription() { return this.itemDescription; }

   public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

   public String getMessageToRecipient() { return this.messageToRecipient; }

   public void setMessageToRecipient(String messageToRecipient) { this.messageToRecipient = messageToRecipient; }

   public String getQuantity() { return this.quantity; }

   public void setQuantity(String quantity) { this.quantity = quantity; }

   public String getSourceCountry() { return this.sourceCountry; }

   public void setSourceCountry(String sourceCountry) { this.sourceCountry = sourceCountry; }

   public String getDestinationCountry() { return this.destinationCountry; }

   public void setDestinationCountry(String destinationCountry) { this.destinationCountry = destinationCountry; }

   public String getOriginHorborLocation() { return this.originHorborLocation; }

   public void setOriginHorborLocation(String originHorborLocation) { this.originHorborLocation = originHorborLocation; }

   public String getSelectedHarborLocation() { return this.selectedHarborLocation; }

   public void setSelectedHarborLocation(String selectedHarborLocation) { this.selectedHarborLocation = selectedHarborLocation; }

   public Date getShippingDate() { return this.shippingDate; }

   public void setShippingDate(Date shippingDate) { this.shippingDate = shippingDate; }

   public Integer getAmount() { return this.amount; }

   public void setAmount(Integer amount) { this.amount = amount; }

   public static Workitem toEntity(WorkitemDTO workitemDTO) {
      Workitem workitem = new Workitem();

      workitem.setAmount(workitemDTO.getAmount());
      workitem.setDestinationCountry(workitemDTO.getDestinationCountry());
      workitem.setItemDescription(workitemDTO.getItemDescription());
      workitem.setWorkitemId(workitemDTO.getWorkitemId());
      workitem.setItemName(workitemDTO.getItemName());
      workitem.setItemType(workitemDTO.getItemType());
      workitem.setMessageToRecipient(workitemDTO.getMessageToRecipient());
      workitem.setOriginHorborLocation(workitemDTO.getOriginHorborLocation());
      workitem.setQuantity(workitemDTO.getQuantity());
      workitem.setSelectedHarborLocation(workitemDTO.getSelectedHarborLocation());
      workitem.setShippingDate(workitemDTO.getShippingDate());
      workitem.setSourceCountry(workitemDTO.getSourceCountry());
      workitem.setUserId(workitemDTO.getUserId());
      
      return workitem;
  }

}
