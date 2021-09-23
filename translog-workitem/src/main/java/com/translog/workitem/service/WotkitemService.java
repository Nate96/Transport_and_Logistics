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
    public List<WorkitemDTO> fetchWorkItemDetails() throws WorkitemException;
    public List<WorkitemDTO> trackWorkitemByUser(Integer userId) throws WorkitemException;
    public VehicleWorkitemDTO fetchWorkItemStatus(String workitemId) throws WorkitemException;
    public TerminalDTO updateWorkItemStatus(String workitemId, TerminalDTO terminalDto) throws WorkitemException;
    public WorkitemDTO fetchWorkItemById(String workitemId) throws WorkitemException;
    public TerminalDTO findTerminalForWorkitem(WorkitemDTO workitemDto, List<TerminalDTO> terminals);
    public String assignTerminalForWorkitem(String workitemId, String terminalId);
    public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId) throws WorkitemException;
    public VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber) throws WorkitemException;
    public String allocateVehicle(String workitemId,List<VehicleDTO> vehicleDtoList) throws WorkitemException;
    public VehicleDTO findVehicleForWorkitem(String workitemId,List<VehicleDTO> vehicleDtoList);

}
