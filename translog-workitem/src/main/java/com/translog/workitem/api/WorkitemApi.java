package com.translog.workitem.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.validation.Valid;

import com.translog.workitem.dto.TerminalDTO;
import com.translog.workitem.dto.VehicleDTO;
import com.translog.workitem.dto.VehicleWorkitemDTO;
import com.translog.workitem.dto.WorkitemDTO;
import com.translog.workitem.dto.WorkitemDriverVehicleDTO;
import com.translog.workitem.exception.WorkitemException;
import com.translog.workitem.service.WotkitemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "workitem")
public class WorkitemApi {

    @Autowired
    private WotkitemService workitemService;

    @Autowired
    private RestTemplate template;

    /**
     * User can create a new workitem.
     * @param WorkitemDTO
     * @return
     * 
     * workItemId will be generated and also amount will be calculated based on base price and the  item type. 
     * NOTE: Baseprice needs to be assigned in the service. As of now provided in sample data. 
     * 
     * Base price details per quantity are:  
     *      Computer Hardware=15999
     *      Oil Container=22.54
     *      Wood=130000, 
     *      Motorcycles=6336
     *      Electonics=13490
     * 
     * Request:
     * { 
     *      "userId": 10001, 
     *      "itemName": "UPS",
     *      "itemType":"Computer Hardware", 
     *      "itemDescription":"Luminous Inverter battery Combo 1100+150AH",
     *      "messageToRecipient":"Please confirm once recived.", 
     *      "capacity":7500, 
     *      "sourceCountry":"India" , 
     *      "destinationCountry":"Singapore" , 
     *      "availableHarborLocations": "Tanjong Pagar",
     *      "shippingDate":'12-Aug-20'
     * }
     * 
     * Response: 
     * {
     *      "workItemId":"J2012",
     *      "userId": 10001,
     *      "itemName": "UPS",
     *       "itemType":"Computer Hardware",
     *       "itemDescription":"Luminous Inverter battery Combo 1100+150AH",
     *       "messageToRecipient":"Please confirm once recived.",
     *       "capacity":7500,
     *       "sourceCountry":"India" ,
     *       "destinationCountry":"Singapore" ,
     *       "availableHarborLocations": "Tanjong Pagar",
     *       "shippingDate":'12-Aug-20' , "amount":119992500
     * }
     * @throws WorkitemException
     */
    @PostMapping()
    public ResponseEntity<WorkitemDTO> createWorkitem(@RequestBody @Valid WorkitemDTO newWorkitem) throws WorkitemException {

        return new ResponseEntity<WorkitemDTO>(workitemService.createWorkitem(newWorkitem), HttpStatus.OK);
    }

    /**
     * User can update their workitem details.
     * @param workitemId
     * @param workitemDTO
     * @return
     * 
     * Fetch the availableHarborLocations from ftr_harbor table based on workItemId value and update selectedHarborLocation or Shipping Date or both.
     * 
     * Request: J2012
     * {
     *      "selectedHarborLocations": "Tanjong Pagar", 
     *      "shippingDate":'22-Aug-20' 
     * }
     * 
     * Response: 
     *      Success:   { "message": “Harbor location and shipping date got updated successfully.”}                                    
     *      Fail:      {"message": “Invalid Data”}
     * @throws WorkitemException
     */
    @PutMapping(value = "/{workitemId}")
    public ResponseEntity<String> updateWorkItem(@PathVariable String workitemId, @RequestBody @Valid WorkitemDTO workitemDTO) throws WorkitemException {

        return new ResponseEntity<String>(workitemService.updateWorkitemId(workitemId, workitemDTO), HttpStatus.OK);
    }

    /**
     * 	User can view the available harbor locations.
     * @param fromCountry
     * @return 
     * 
     * 	Fetch the selected HarborLocations from ftr_harbor table based on the fromContry value and it will return the list.
     * Request: Singapore
     * Response: 
     *      Success:    { Available Harbor locations in Singapore: "Tanjong Pagar", "Jurang"}                                    
     *      Fail:       {"message": “Invalid Data”}
     * @throws WorkitemException
     */
    @GetMapping(value = "/{fromCountry}")
    public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable String fromCountry) throws WorkitemException {

        return new ResponseEntity<List<String>>(workitemService.fetchAvailableHarborLocations(fromCountry), HttpStatus.OK);
    }

    /**
     * Admin can view all the workitem details.
     * @return
     * 
     * Fetch all available workItem details.
     * 
     * Response: 
     * {
     *      "workItemId":"J2012",
     *      "userId": 10001,
     *      "itemName": "UPS",
     *      "itemType":"Computer Hardware",
     *      "itemDescription":"Luminous Inverter battery Combo 1100+150AH",
     *      "messageToRecipient":"Please confirm once recived.",
     *      "capacity":7500,
     *      "fromCountry":"India" ,
     *      "destinationCountry":"Singapore" ,
     *      "availableHarborLocations": "Tanjong Pagar",
     *      "shippingDate":'12-Aug-20'
     *  }
     * @throws WorkitemException
     */
    @GetMapping()
    public ResponseEntity<List<WorkitemDTO>> fetchWorkItemDetails() throws WorkitemException { 

        return new ResponseEntity<List<WorkitemDTO>>(workitemService.fetchWorkItemDetails(), HttpStatus.OK); 
    }

    /**
     * User can track their workitem status details.
     * @param userId
     * @return
     * 
     * Fetch the workItemId based on the userId and then check the workItem status based on the workItemId 
     * from ftr_vehicle_workItem table and then display to the user.
     * 
     * Request: 10001
     * Response:
     * { 
     *      "vehicleNumber":"UE7890", 
     *      "workItemId":"J2012", 
     *      "workItemStatus":"InProgress"
     * }
     * @throws WorkitemException
     */
    @GetMapping(value = "/managed-user/{userId}")
    public ResponseEntity<List<WorkitemDTO>> trackWorkitemByUser(@PathVariable Integer userId) throws WorkitemException { 
        
        return new ResponseEntity<List<WorkitemDTO>>(workitemService.trackWorkitemByUser(userId), HttpStatus.OK); 
    }

    /**
     * Admin can track the status of each workitem based on workitemId.
     * @param workitemId
     * @return
     * 
     * Request: J2013
     * Response: 
     *      Success:    {WorkItem details from  ftr_vehicle_workItem"}                                    
     *      Fail:       {message: “Invalid Data”}
     * @throws WorkitemException
     */
    @GetMapping(value = "/managed-user/{workitemId}")
    public ResponseEntity<VehicleWorkitemDTO> fetchWorkItemStatus(@PathVariable String workitemId) throws WorkitemException { 
        
        return new ResponseEntity<VehicleWorkitemDTO>(workitemService.fetchWorkItemStatus(workitemId), HttpStatus.OK); 
    }

    /**
     * Admin can update the status of the workitem as "Completed" or "NotInitiated" or "InProgress".
     * @param workitemId
     * @return
     * 
     * Update WorKItemId status as completed if shipping date and current date are same/shipping date is < current date. 
     * If WorkItemId status is completed then update Vehicle status as active.Update capacity of Terminal if WorkItem status is completed
     * 
     * request: J2012
     * response: 
     *      Success:    { "message": “Work item status has updated successfully.”}                                    
     *      Fail:       {"message": “Invalid Data”}
     * @throws WorkitemException
     */
    // TODO Need to clairify functionality, why do we need terminal dto
    @PutMapping(value = "/managed-update/{workitemId}")
    public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workitemId) throws WorkitemException { 
        TerminalDTO terminalDTO = template.getForObject("localhost" + "/Terminal/" + workitemId , TerminalDTO.class);

       TerminalDTO results = workitemService.updateWorkItemStatus(workitemId, terminalDTO);

       if(terminalDTO == results)
            return new ResponseEntity<String>("Work item status has been updated successfully", HttpStatus.OK); 

        return new ResponseEntity<String>("Invalid", HttpStatus.OK);
    }

    /**
     * Admin can assign the terminal for workitem based on the item type
     * @param workitemId
     * @return
     * 
     * Fetch TerminalID based on ItemType of this WorkItem(call to TerminalService) 
     * insert in ftr_workItem_Terminal table.Update the Terminal table 's 
     * AvailableCapacity field by reducing the availableCapacity=avaliableCapacity-quantity (call to TerminalService)
     * 
     * Request: J2012
     * @throws WorkitemException
     */
    @PostMapping(value = "/managed-update/{workitemId}")
    public 	ResponseEntity<String> assignTerminalForWorkitem(@PathVariable String workitemId) throws WorkitemException { 
        TerminalDTO terminalDTO = null;
        WorkitemDTO workitemDTO = workitemService.fetchWorkItemById(workitemId);

        List<TerminalDTO> terminalDTOList = template.getForObject("Localhost" + "/Terminal" + "/fetchTerminalsByItemType/" + workitemDTO.getItemType(), List.class);

        for(TerminalDTO dto : terminalDTOList) {
            if(dto.getStatus().equals("Available"))
                terminalDTO = dto;
        }

        if(terminalDTO == null)
            throw new WorkitemException("No available terminals");
        
        template.put("localhost" + "/Termainal/" + terminalDTO.getTerminalId() + (terminalDTO.getAvailableCapacity() - 1), null);
         
        return new ResponseEntity<String>(workitemService.assignTerminalForWorkitem(workitemId, terminalDTO.getTerminalId()), HttpStatus.OK); 
    }

    /**
     * Admin can view the workitem details based on the vehicleNumber.
     * @param vehicleNumber
     * @return
     * 
     * Fetch the vehicle , workItem and status from ftr_driver_vehicle_workItem
     * 
     * Request: UE7890
     * Response:
     * {
     *      "vehicleNumber":"UE7890",
     *      "workItemId":"M7998", 
     *      "workItemStatus":"Completed"
     * }
     * @throws WorkitemException
     */
    @GetMapping(value = "/managed-vehicle/{vehicleNumber}")
    public ResponseEntity<VehicleWorkitemDTO> fetchWorkItemDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws WorkitemException { 
        
        return new ResponseEntity<VehicleWorkitemDTO>(workitemService.fetchWorkItemDetailsByVehicleNumber(vehicleNumber), HttpStatus.OK); 
    }

    /**
     * Admin can allocate vehicle for a workitem
     * @param workitemId
     * @return
     * 
     * 1. Consume VehicleMS to identify the available location based on the workitem type and harbor location and fetch the first available vehicle and assign to the given workitem.
     * 2. Also validate while selecting vehicle it should in active state. 
     * 3. Check this work item id is assigned with vehicle already, if yes throw appropriate error message.
     * 
     * Request: J2013
     *      {"VehicleNumer":"WK7876"}
     * Response: 
     * 	    Success:    { WorkItem allocated with  vehicle"}                                    
     *      Fail:       {"message": “Invalid Data”}
     * @throws WorkitemException
     * 
     */
    // TODO Auto-generated method stub
    @PostMapping(value = "/managed-vehicle/{workitemId}")
    public ResponseEntity<String> allocateVehicle(@PathVariable String workitemId) throws WorkitemException { 
        //TODO - call vehicleMS
        VehicleDTO vehicleDTO = new VehicleDTO(); //get vehicles in that location return list
        List<VehicleDTO> vehicleDtoList = new ArrayList<>();
        WorkitemDTO workitemDTO = workitemService.fetchWorkItemById(workitemId);

        return new ResponseEntity<String>(workitemService.allocateVehicle(workitemId, vehicleDtoList), HttpStatus.OK); 
    }
}


