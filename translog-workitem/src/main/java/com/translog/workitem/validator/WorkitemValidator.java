package com.translog.workitem.validator;

import com.translog.workitem.exception.WorkitemException;
import com.translog.workitem.dto.WorkitemDTO;

public class WorkitemValidator {

    public Boolean validateWorkitem(WorkitemDTO dto) throws WorkitemException {
        return isAmountValid(dto.getAmount().toString());
    }


    private Boolean isAmountValid(String amount) throws WorkitemException {
		try {
		  Integer.parseInt(amount);
          return true;
		}
		catch(NumberFormatException e) {
		  //not a double
		  throw new WorkitemException("vehicle.maxLiftingCapacity.invalid ");
		}
    }
    
}
