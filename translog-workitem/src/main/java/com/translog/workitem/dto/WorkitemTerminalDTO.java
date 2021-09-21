package com.translog.workitem.dto;

import com.translog.workitem.entity.WorkitemTerminal;

public class WorkitemTerminalDTO {

    private String workitemId;
    private String terminalId;

    public String getWorkitemId() { return this.workitemId; }

    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public String getTerminalId() { return this.terminalId; }

    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }

    public static WorkitemTerminalDTO toDTO(WorkitemTerminal workitemTerminal) {
        WorkitemTerminalDTO dto = new WorkitemTerminalDTO();

        dto.setTerminalId(workitemTerminal.getTerminalId());
        dto.setWorkitemId(workitemTerminal.getWorkitemId());

        return dto;
    }
}
