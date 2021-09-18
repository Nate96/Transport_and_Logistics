package com.translog.workitem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

public class WorkitemDTO {

    //only Integer - workitem.userId.invalid = Invalid user id
    @NotNull(message = "{workitem.userId.must}")
    @Size(max = 5, message = "{workitem.userId.invalid}")
    private Long userId;

    @NotEmpty(message = "{workitem.itemName.must}")
    @Size(max = 5, message = "{workitem.itemName.invalid}")
    private String itemName;

    @NotEmpty(message = "{workitem.itemType.must}")
    @Size(min = 3, max = 25, message = "{workitem.itemType.invalid }")
    private String itemType;

    @NotEmpty(message = "{workitem.itemDescription.must}")
    @Size(min = 10, max = 45, message = "{workitem.itemDescription.invalid}")
    private String itemDescription;

    @NotEmpty(message = "{workitem.messageToRecipient.must}")
    @Size(min = 10, max = 50, message = "{workitem.messageToRecipient.invalid}")
    private String messageToRecipient;

    @NotEmpty(message = "{workitem.quantity.must}")
    // Accept only interger(i.e no of items) or accept integer first and last 2 or 3 digits must be character i.e kg/lit
    private String quantity;

    @NotEmpty(message = "{workitem.sourceCountry.must}")
    @Size(min = 5, max = 25, message = "{workitem.sourceCountry.invalid}")
    private String sourceCountry;

    @NotEmpty(message = "{workitem.destinationCountry.must}")
    @Size(min = 5, max = 25, message = "{workitem.destinationCountry.invalid}")
    private String destinationCountry;

    @NotEmpty(message = "{workitem.selectedHarborLocation.must}")
    @Size(min = 5, max = 25, message = "{workitem.selectedHarborLocation.invalid}")
    private String originHorborLocation;

    @NotEmpty(message = "{workitem.selectedHarborLocation.must}")
    @Size(min = 5, max = 25, message = "{workitem.selectedHarborLocation.invalid}")
    private String selectedHarborLocation;

    @NotNull(message = "{workitem.shippingDate.must}")
    // workitem.shippingDate.invalid = Invalid Shipping date, should be a future date
    private Date shippingDate;

    // Accept only integer
    private Integer amount;
 
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
}
