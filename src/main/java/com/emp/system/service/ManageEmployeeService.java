package com.emp.system.service;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;
import org.springframework.stereotype.Service;

@Service
public interface ManageEmployeeService {
    public ApiResponse<EmployeeDetailResponse> getEmployeeDetails(String employeeId)throws CommonException;

    ApiResponse<EmployeeDetailRequest> updateEmployeeDetails(EmployeeDetailRequest employeeDetailRequest);

    ApiResponse<EmployeeDetailRequest> saveEmployeeDetails(EmployeeDetailRequest employeeDetailRequest);
}
