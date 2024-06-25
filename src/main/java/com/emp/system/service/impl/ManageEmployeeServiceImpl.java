package com.emp.system.service.impl;

import com.emp.system.entity.EmployeeDetailsEntity;
import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;
import com.emp.system.model.ResignEmployeeRequest;
import com.emp.system.repository.ManageEmployeeRepository;
import com.emp.system.service.ManageEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
//    @Audit(Employee="Employee",Action="Add")
    public ApiResponse<EmployeeDetailRequest> saveEmployeeDetails(EmployeeDetailRequest employeeDetailRequest) {
        ApiResponse<EmployeeDetailRequest> response = new ApiResponse<>();

        EmployeeDetailsEntity employeeDetailsEntity=new EmployeeDetailsEntity();
        employeeDetailsEntity.setEmployeeName(employeeDetailRequest.getEmployeeName());
        employeeDetailsEntity.setEmployeeEmail(employeeDetailRequest.getEmployeeEmail());
        response.setData(employeeDetailRequest);
        manageEmployeeRepository.save(employeeDetailsEntity);
        return response;
    }

    @Override
    public ApiResponse<List<EmployeeDetailResponse>> getAllEmployeeDetails() {
        ApiResponse<List<EmployeeDetailResponse>> response=new ApiResponse<>();
        List<EmployeeDetailResponse> employeeDetailResponses=new ArrayList<>();
        List<EmployeeDetailsEntity> employeeDetailsEntityList = manageEmployeeRepository.findAll();
        for(EmployeeDetailsEntity employeeDetails:employeeDetailsEntityList){
            EmployeeDetailResponse employeeDetailResponse=new EmployeeDetailResponse();
            employeeDetailResponse.setEmployeeEmail(employeeDetails.getEmployeeEmail());
            employeeDetailResponse.setEmployeeId(String.valueOf(employeeDetails.getEmployeeId()));
            employeeDetailResponse.setEmployeeRole(employeeDetails.getEmployeeRole());
            employeeDetailResponses.add(employeeDetailResponse);
        }

        response.setData(employeeDetailResponses);
        return response;
    }

    @Override
    public ApiResponse<ResignEmployeeRequest> resignEmployee(ResignEmployeeRequest resignEmployeeRequest) throws CommonException{
        ApiResponse<ResignEmployeeRequest> response = new ApiResponse<>();

        EmployeeDetailsEntity employeeDetailsEntity=manageEmployeeRepository.findByEmployeeId(UUID.fromString(resignEmployeeRequest.getId()));
        if(employeeDetailsEntity==null){
            throw new CommonException("Id not found", HttpStatus.BAD_REQUEST);
        }
        employeeDetailsEntity.setEmployeeStatus(resignEmployeeRequest.getEmployeeStatus());
        response.setData(resignEmployeeRequest);
        manageEmployeeRepository.save(employeeDetailsEntity);
        return response;
    }

    @Override
//    @Audit(Employee="Employee",Action="Update")
    public ApiResponse<EmployeeDetailRequest> updateEmployeeDetails(EmployeeDetailRequest employeeDetailRequest) throws CommonException{
        ApiResponse<EmployeeDetailRequest> response = new ApiResponse<>();

        EmployeeDetailsEntity employeeDetailsEntity=manageEmployeeRepository.findByEmployeeId(UUID.fromString(employeeDetailRequest.getEmployeeId()));
        if(employeeDetailsEntity==null){
            throw new CommonException("Id not found", HttpStatus.BAD_REQUEST);
        }
        employeeDetailsEntity.setEmployeeName(employeeDetailRequest.getEmployeeName());
        employeeDetailsEntity.setEmployeeEmail(employeeDetailRequest.getEmployeeEmail());
        response.setData(employeeDetailRequest);
        manageEmployeeRepository.save(employeeDetailsEntity);
        return response;
    }
}
