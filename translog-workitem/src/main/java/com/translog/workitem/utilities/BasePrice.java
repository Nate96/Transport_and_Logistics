package com.translog.workitem.utilities;

public class BasePrice {

    private final Integer COMPUTER_HARDWARE = 15999;
    private final Double OIL_CONTAINER = 22.24;
    private final Integer WOOD = 130000;
    private final Integer MOTORCYCLES = 6336;
    private final Integer ELECTRONICS = 13490;

    public Integer getComputerHardwarePrice() { return this.COMPUTER_HARDWARE; }

    public Double getOilContainerPrice() { return this.OIL_CONTAINER; }

    public Integer getWoodPrice() { return this.WOOD; }

    public Integer getMotorcyclePrice() { return this.MOTORCYCLES; }

    public Integer getElectronicPrice() { return this.ELECTRONICS; }
    
}