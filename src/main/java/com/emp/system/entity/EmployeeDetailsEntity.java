package com.emp.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee_detail")
public class EmployeeDetailsEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "employee_id")
    UUID employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_role")
    private String employeeRole;
    @Column(name = "employment_satrt_date")
    private Date employmentStartDate;
    @Column(name = "employment_satus")
    private String employeeStatus;
    @Column(name = "employment_last_working_date")
    private Date employmentLastWorkingDate;
    @Column(name = "employee_manager")
    private String employeeManager;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_dob")
    private Date employeeDOB;
}
