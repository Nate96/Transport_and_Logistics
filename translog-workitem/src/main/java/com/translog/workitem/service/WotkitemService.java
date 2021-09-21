package com.translog.workitem.service;

import java.util.List;

import com.translog.workitem.dto.TerminalDTO;
import com.translog.workitem.dto.VehicleDTO;
import com.translog.workitem.dto.WorkitemDTO;
import com.translog.workitem.dto.WorkitemTerminalDTO;
import com.translog.workitem.dto.VehicleWorkitemDTO;
import com.translog.workitem.exception.WorkitemException;

public interface WotkitemService {
    public WorkitemDTO createWorkitem(WorkitemDTO workitemDto) throws WorkitemException;
    public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO) throws WorkitemException;
    public List<String> fetchAvailableHarborLocations(String country) throws WorkitemException;
    public List<WorkitemDTO> fetchWorkItemDetails();
    public 	List<WorkitemDTO> trackWorkitemByUser(Integer userId);
    public VehicleWorkitemDTO fetchWorkItemStatus(String workitemId);
    public TerminalDTO updateWorkItemStatus(String workitemId, TerminalDTO terminalDto);
    public WorkitemDTO fetchWorkItemById(String workitemId);
    public TerminalDTO findTerminalForWorkitem(WorkitemDTO workitemDto, List<TerminalDTO> terminals);
    public String assignTerminalForWorkitem(String workitemId, String terminalId);
    public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId);
    public VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber);
    public String allocateVehicle(String workitemId,List<VehicleDTO> vehicleDtoList);
    public VehicleDTO findVehicleForWorkitem(String workitemId,List<VehicleDTO> vehicleDtoList);

}
