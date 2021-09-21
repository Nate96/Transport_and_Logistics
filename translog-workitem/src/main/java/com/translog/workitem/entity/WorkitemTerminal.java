package com.translog.workitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.workitem.dto.WorkitemTerminalDTO;

@Entity
@Table(name = "ftr_workitem_terminal")
public class WorkitemTerminal {
    @Id
    private String workitemId;
    private String terminalId;

    public String getWorkitemId() { return this.workitemId; }

    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public String getTerminalId() { return this.terminalId; }

    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }

    public static WorkitemTerminal toEntity(WorkitemTerminalDTO workitemTerminalDTO) {
        WorkitemTerminal workitemTerminal = new WorkitemTerminal();

        workitemTerminal.setTerminalId(workitemTerminalDTO.getTerminalId());
        workitemTerminal.setWorkitemId(workitemTerminalDTO.getWorkitemId());

        return workitemTerminal;
    }

}
