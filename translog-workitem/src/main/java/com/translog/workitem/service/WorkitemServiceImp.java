package com.translog.workitem.service;

import java.util.List;

import com.translog.workitem.dto.TerminalDTO;
import com.translog.workitem.dto.VehicleDTO;
import com.translog.workitem.dto.WorkitemDTO;
import com.translog.workitem.dto.WorkitemTerminalDTO;
import com.translog.workitem.dto.WorkitemVehicleDTO;

import org.springframework.stereotype.Service;

@Service
public class WorkitemServiceImp implements WotkitemService{

    /**
     * 	This method is used to insert the new workitem details  and 
     *  generate workitemId as per sample data. Validate the inputs according 
     *  to DTO validations.
     */
    @Override
    public WorkitemDTO createWorkitem(WorkitemDTO workitemDto) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * This method is used to update the shipping date and harbor location. 
     * Throw appropriate error message if the workitem is not found.
     */
    @Override
    public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return the harbor locations based on the given country.
     */
    @Override
    public List<String> fetchAvailableHarborLocations(String country) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return all the workitem details. If there are no workitems available then 
     * throw proper error message.
     */
    @Override
    public List<WorkitemDTO> fetchWorkItemDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Fetch the workitems created by the user based on the userId.  
     * If there are no workitems found then throw proper error message.
     */
    @Override
    public List<WorkitemDTO> trackWorkitemByUser(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return the workitem details along with assigned vehicle details 
     * based on the workitemId.
     */
    @Override
    public WorkitemVehicleDTO fetchWorkItemStatus(String workitemId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 	Update the workitem status as "Completed' if the shipping date is equal 
     * to the current date and release the assigned terminal. Throw WORKITEM_NOT_FOUND 
     * if the workitem is not found.
     */
    @Override
    public TerminalDTO updateWorkItemStatus(String workitemId, TerminalDTO terminalDto) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return the workitem details based on the workitemId.
     */
    @Override
    public WorkitemDTO fetchWorkItemById(String workitemId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * This method helps to identify the available terminal for a new workitem.
     */
    @Override
    public TerminalDTO findTerminalForWorkitem(WorkitemDTO workitemDto, List<TerminalDTO> terminals) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * This mehod is used to assign the terminal for new workitem based on the item type.
     */
    @Override
    public String assignTerminalForWorkitem(String workitemId, String terminalId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Fetch the woritemdetails along with the assigned terminal details.
     */
    @Override
    public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return the workitem details based on the vehicle number.
     */
    @Override
    public WorkitemVehicleDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Check the workitem is valid, if valida then check the workitem is assigned with vehicle 
     * already if yes then throw WORKITEM_VEHICLE_ALLOCATED else allocate a new vehicle for the
     * given workitem id.
     */
    @Override
    public String allocateVehicle(String workitemId, List<VehicleDTO> vehicleDtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Identify the available vehicle for the workitem.
     */
    @Override
    public VehicleDTO findVehicleForWorkitem(String workitemId, List<VehicleDTO> vehicleDtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
