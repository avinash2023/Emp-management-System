package com.emp.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name="employee_table")
public class LoginEntity {
    @Column(name="employee_id")
    String employeeId;
}
