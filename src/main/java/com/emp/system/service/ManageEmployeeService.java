package com.emp.system.service;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManageEmployeeService {
    public ApiResponse<EmployeeDetailResponse> getEmployeeDetails(String employeeId)throws CommonException;

    ApiResponse<EmployeeDetailRequest> updateEmployeeDetails(EmployeeDetailRequest employeeDetailRequest) throws CommonException;

    ApiResponse<EmployeeDetailRequest> saveEmployeeDetails(EmployeeDetailRequest employeeDetailRequest);

    ApiResponse<List<EmployeeDetailResponse>> getAllEmployeeDetails();
}
