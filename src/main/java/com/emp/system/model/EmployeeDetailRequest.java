package com.emp.system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailRequest {
    private static final long serialVersionUID = 1L;
    private String employeeId;
    private String employeeName;
    private String employeeRole;
    private Date employementStartDate;
    private String employeeStatus;
    private Date employeeLastWorkingDate;
    private String employeeManager;
    private String employeeEmail;
    private Date employeeDOB;
}
