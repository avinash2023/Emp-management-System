package com.emp.system.service.impl;

import com.emp.system.entity.EmployeeDetailsEntity;
import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;
import com.emp.system.repository.ManageEmployeeRepository;
import com.emp.system.service.ManageEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ManageEmployeeServiceImpl implements ManageEmployeeService {

    @Autowired
    ManageEmployeeRepository manageEmployeeRepository;

    @Override
    public ApiResponse<EmployeeDetailResponse> getEmployeeDetails(String employeeId) throws CommonException {
        ApiResponse<EmployeeDetailResponse> response = new ApiResponse<>();
        EmployeeDetailResponse employeeDetailResponse = new EmployeeDetailResponse();
        EmployeeDetailsEntity employeeDetailsEntity = manageEmployeeRepository.findByEmployeeId(UUID.fromString(employeeId));
        if(employeeDetailsEntity==null){
            throw new CommonException("Id not found", HttpStatus.BAD_REQUEST);
        }
        employeeDetailResponse.setEmployeeEmail(employeeDetailsEntity.getEmployeeEmail());
        employeeDetailResponse.setEmployeeId(String.valueOf(employeeDetailsEntity.getEmployeeId()));
        employeeDetailResponse.setEmployeeRole(employeeDetailsEntity.getEmployeeRole());
        response.setData(employeeDetailResponse);
        return response;
    }

    @Override
    public ApiResponse<EmployeeDetailRequest> updateEmployeeDetails(EmployeeDetailRequest employeeDetailRequest) {
        ApiResponse<EmployeeDetailRequest> response = new ApiResponse<>();

        EmployeeDetailsEntity employeeDetailsEntity=new EmployeeDetailsEntity();
        employeeDetailsEntity.setEmployeeName(employeeDetailRequest.getEmployeeName());
        employeeDetailsEntity.setEmployeeEmail(employeeDetailRequest.getEmployeeEmail());
        response.setData(employeeDetailRequest);
        return response;
    }

    @Override
    public ApiResponse<EmployeeDetailRequest> saveEmployeeDetails(EmployeeDetailRequest employeeDetailRequest) {
        ApiResponse<EmployeeDetailRequest> response = new ApiResponse<>();

        EmployeeDetailsEntity employeeDetailsEntity=manageEmployeeRepository.findByEmployeeId(UUID.fromString(employeeDetailRequest.getEmployeeId()));
        employeeDetailsEntity.setEmployeeName(employeeDetailRequest.getEmployeeName());
        employeeDetailsEntity.setEmployeeEmail(employeeDetailRequest.getEmployeeEmail());
        response.setData(employeeDetailRequest);
        return response;
    }
}
