package com.translog.workitem.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.translog.workitem.dto.TerminalDTO;
import com.translog.workitem.dto.VehicleDTO;
import com.translog.workitem.dto.WorkitemDTO;
import com.translog.workitem.dto.WorkitemTerminalDTO;
import com.translog.workitem.dto.VehicleWorkitemDTO;
import com.translog.workitem.entity.Harbor;
import com.translog.workitem.entity.VehicleWorkitem;
import com.translog.workitem.entity.Workitem;
import com.translog.workitem.entity.WorkitemTerminal;
import com.translog.workitem.exception.WorkitemException;
import com.translog.workitem.repository.HarborRepository;
import com.translog.workitem.repository.VehicleWorkitemRepository;
import com.translog.workitem.repository.WorkitemRepository;
import com.translog.workitem.repository.WorkitemTerminalRepository;
import com.translog.workitem.validator.WorkitemValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkitemServiceImp implements WotkitemService{

    @Autowired
    WorkitemRepository workitemRepository;

    @Autowired
    WorkitemValidator workitemValidator;

    @Autowired
    HarborRepository harborRepository;

    @Autowired
    VehicleWorkitemRepository vehicleWorkitemRepository;

    @Autowired
    WorkitemTerminalRepository workitemTerminalRepository;


    /**
     * 	This method is used to insert the new workitem details  and 
     *  generate workitemId as per sample data. Validate the inputs according 
     *  to DTO validations.
     * @throws WorkitemException
     */
    //TODO - review validator call in rest traning
    @Override
    public WorkitemDTO createWorkitem(WorkitemDTO workitemDto) throws WorkitemException {

        Workitem workitem = Workitem.toEntity(workitemDto);
        
        if(!workitemValidator.validateWorkitem(workitemDto)) 
            return null;
        
        workitemRepository.save(workitem);

        // save to other tabls

        return workitemDto;
        
    }

    /**
     * This method is used to update the shipping date and harbor location. 
     * Throw appropriate error message if the workitem is not found.
     * @throws WorkitemException
     */
    @Override
    public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO) throws WorkitemException {
        
        Optional<Workitem> results = workitemRepository.findById(workitemId);
        Workitem workitem = results.orElseThrow(() -> new WorkitemException("workitem.notFound"));

        workitem.setSelectedHarborLocation(workitemDTO.getSelectedHarborLocation());
        workitem.setShippingDate(workitemDTO.getShippingDate());

        workitemRepository.save(workitem);

        return "Harbor location and shipping date got updated successfully.";
    }

    /**
     * Return the harbor locations based on the given country.
     * @throws WorkitemException
     */
    @Override
    public List<String> fetchAvailableHarborLocations(String country) throws WorkitemException {

        Optional<Harbor> results = harborRepository.findById(country);
        Harbor harbor = results.orElseThrow(() -> new WorkitemException("harbor.notFound"));

        return Arrays.asList(harbor.getAvailableHarborLocation().split(", "));
    }

    /**
     * Return all the workitem details. If there are no workitems available then 
     * throw proper error message.
     * @throws WorkitemException
     */
    @Override
    public List<WorkitemDTO> fetchWorkItemDetails() throws WorkitemException {

        List<Workitem> results = workitemRepository.findAll();

        if(results.isEmpty()) 
            throw new WorkitemException("workitem.notFound");

        List<WorkitemDTO> workitemDTOList = new ArrayList<WorkitemDTO>();
        for(Workitem workitem : results) {
            workitemDTOList.add(WorkitemDTO.toDto(workitem));
        }

        return workitemDTOList;
    }

    /**
     * Fetch the workitems created by the user based on the userId.  
     * If there are no workitems found then throw proper error message.
     * @throws WorkitemException
     */
    @Override
    public List<WorkitemDTO> trackWorkitemByUser(Integer userId) throws WorkitemException {

        List<Workitem> results = workitemRepository.findByUserId(userId.longValue());
        
        if(results.isEmpty())
            throw new WorkitemException("workitem.notFound");
        
        List<WorkitemDTO> workitemDTOList = new ArrayList<WorkitemDTO>();
        for(Workitem workitem : results) {
            workitemDTOList.add(WorkitemDTO.toDto(workitem));
        }

        return workitemDTOList;
    }

    /**
     * Return the workitem details along with assigned vehicle details 
     * based on the workitemId.
     * @throws WorkitemException
     */
    @Override
    public VehicleWorkitemDTO fetchWorkItemStatus(String workitemId) throws WorkitemException {
 
        Optional<VehicleWorkitem> results = vehicleWorkitemRepository.findById(workitemId);
        VehicleWorkitem vehicleWorkitem = results.orElseThrow(() -> new WorkitemException("vehicle.notFound"));
        
        return VehicleWorkitemDTO.toDTO(vehicleWorkitem);
    }

    /**
     * 	Update the workitem status as "Completed' if the shipping date is equal 
     * to the current date and release the assigned terminal. Throw WORKITEM_NOT_FOUND 
     * if the workitem is not found.
     * @throws WorkitemException
     */
    @Override
    public TerminalDTO updateWorkItemStatus(String workitemId, TerminalDTO terminalDto) throws WorkitemException {

        Optional<Workitem> results = workitemRepository.findById(workitemId);
        Workitem workitem = results.orElseThrow(() -> new WorkitemException("WORKITEM_NOT_FOUND"));

        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(workitem.getShippingDate()));
        if(localDate.compareTo(LocalDate.now()) == 0) {
            Optional<VehicleWorkitem> results2 = vehicleWorkitemRepository.findById(workitemId);
            VehicleWorkitem vehicleWorkitem = results2.orElseThrow(() -> new WorkitemException("WORKITEM_NOT_FOUND"));

            vehicleWorkitem.setAssignedWorkitemStatus("Complete");
            vehicleWorkitemRepository.save(vehicleWorkitem);
        }

        return terminalDto;
    }

    /**
     * Return the workitem details based on the workitemId.
     * @throws WorkitemException
     */
    @Override
    public WorkitemDTO fetchWorkItemById(String workitemId) throws WorkitemException {

        Optional<Workitem> results = workitemRepository.findById(workitemId);
        Workitem workitem = results.orElseThrow(() -> new WorkitemException("workitem.notFound"));
        
        return WorkitemDTO.toDto(workitem);
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
     * @throws WorkitemException
     */
    @Override
    public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId) throws WorkitemException {
  
        Optional<WorkitemTerminal> results = workitemTerminalRepository.findById(workitemId);
        WorkitemTerminal workitemTerminal = results.orElseThrow(() -> new WorkitemException("terminal.notAvailable"));
        
        return WorkitemTerminalDTO.toDTO(workitemTerminal);
    }

    /**
     * Return the workitem details based on the vehicle number.
     * @throws WorkitemException
     */
    @Override
    public VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber) throws WorkitemException {

        Optional<VehicleWorkitem> results = vehicleWorkitemRepository.findByVehicleNumber(vehicleNumber);
        VehicleWorkitem vehicleWorkitem = results.orElseThrow(() -> new WorkitemException("terminal.notAvailable"));
        
        return VehicleWorkitemDTO.toDTO(vehicleWorkitem);
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
