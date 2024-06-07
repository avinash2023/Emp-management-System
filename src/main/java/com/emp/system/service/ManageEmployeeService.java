package com.emp.system.service;

import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;

public interface ManageEmployeeService {
    public ApiResponse<EmployeeDetailResponse> getEmployeeDetails(String employeeId);

    ApiResponse<EmployeeDetailRequest> updateEmployeeDetails(EmployeeDetailRequest employeeDetailRequest);

    ApiResponse<EmployeeDetailRequest> saveEmployeeDetails(EmployeeDetailRequest employeeDetailRequest);
}
