package com.translog.workitem.api;

import java.util.List;

import javax.validation.Valid;

import com.translog.workitem.dto.VehicleWorkitemDTO;
import com.translog.workitem.dto.WorkitemDTO;
import com.translog.workitem.dto.WorkitemDriverVehicleDTO;
import com.translog.workitem.service.WotkitemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "workitem")
public class WorkitemApi {

    @Autowired
    private WotkitemService workitemService;

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
     */
    // TODO Auto-generated method stub
    @PostMapping()
    public ResponseEntity<WorkitemDTO> createWorkitem(@RequestBody @Valid WorkitemDTO newWorkitem) {

        return null;
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
     */
    // TODO Auto-generated method stub
    @PutMapping(value = "/{workitemId}")
    public ResponseEntity<String> updateWorkItem(@PathVariable String workitemId, @RequestBody @Valid WorkitemDTO workitemDTO) {

        return null;
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
     */
    // TODO Auto-generated method stub
    @GetMapping(value = "/{fromCountry}")
    public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable String fromCountry) {

        return null;
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
     */
    // TODO Auto-generated method stub
    @GetMapping()
    public ResponseEntity<List<WorkitemDTO>> fetchWorkItemDetails() { return null; }

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
     */
    // TODO Auto-generated method stub
    @GetMapping(value = "/managed-user/{userId}")
    public ResponseEntity<List<WorkitemDTO>> trackWorkitemByUser(@PathVariable Integer userId) {return null; }

    /**
     * Admin can track the status of each workitem based on workitemId.
     * @param workitemId
     * @return
     * 
     * Request: J2013
     * Response: 
     *      Success:    {WorkItem details from  ftr_vehicle_workItem"}                                    
     *      Fail:       {message: “Invalid Data”}
     */
    // TODO Auto-generated method stub
    @GetMapping(value = "/managed-user/{workitemId}")
    public ResponseEntity<WorkitemDriverVehicleDTO> fetchWorkItemStatus(@PathVariable String workitemId) { return null; }

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
     */
    // TODO Auto-generated method stub
    @PutMapping(value = "/managed-update/{workitemId}")
    public ResponseEntity<String> updateWorkItemStatus(String workitemId) { return null; }

    /**
     * Admin can assign the terminal for workitem based on the item type
     * @param workitemId
     * @return
     * 
     * Fetch TerminalID based on ItemType of this WorkItem(call to TerminalService) and insert in ftr_workItem_Terminal table.Update the Terminal table 's 
     * AvailableCapacity field by reducing the  availableCapacity=avaliableCapacity-quantity (call to TerminalService)
     * 
     * Request: J2012
     */
    // TODO Auto-generated method stub
    @PostMapping(value = "/managed-update/{workitemId}")
    public 	ResponseEntity<String> assignTerminalForWorkitem(@PathVariable String workitemId) { return null; }

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
     */
    // TODO Auto-generated method stub
    @GetMapping(value = "/managed-vehicle/{vehicleNumber}")
    public ResponseEntity<VehicleWorkitemDTO> fetchWorkItemDetailsByVehicleNumber(@PathVariable String vehicleNumber) { return null; }

    /**
     * Admin can allocate vehicle for a workitem
     * @param workitemId
     * @return
     * 
     * 1.Consume VehicleMS to identify the available location based on the workitem type and harbor location and fetch the first available vehicle and assign to the given workitem.
     * 2. Also validate while selecting vehicle it should in active state. 
     * 3. Check this work item id is assigned with vehicle already, if yes throw appropriate error message.
     * 
     * Request: J2013
     *      {"VehicleNumer":"WK7876"}
     * Response: 
     * 	    Success:    { WorkItem allocated with  vehicle"}                                    
     *      Fail:       {"message": “Invalid Data”}
     * 
     */
    // TODO Auto-generated method stub
    @PostMapping(value = "/managed-vehicle/{workitemId}")
    public ResponseEntity<String> allocateVehicle(@PathVariable String workitemId) { return null; }
}
