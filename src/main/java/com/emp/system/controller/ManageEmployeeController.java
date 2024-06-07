package com.emp.system.controller;

import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;
import com.emp.system.service.ManageEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/employee")
public class ManageEmployeeController {

    @Autowired
    ManageEmployeeService manageEmployeeService;

    @GetMapping(value="/getEmployee")
    public ResponseEntity<ApiResponse<EmployeeDetailResponse>> getEmployeeDetails(String employeeId){
        ApiResponse<EmployeeDetailResponse> response= manageEmployeeService.getEmployeeDetails(employeeId);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @GetMapping(value="/updateEmployee")
    public ResponseEntity<ApiResponse<EmployeeDetailRequest>> updateEmployeeDetails(EmployeeDetailRequest employeeDetailRequest){
        ApiResponse<EmployeeDetailRequest> response= manageEmployeeService.updateEmployeeDetails(employeeDetailRequest);
        return new ResponseEntity<>(response,response.getStatus());
    }
    @GetMapping(value="/saveEmployee")
    public ResponseEntity<ApiResponse<EmployeeDetailRequest>> saveEmployeeDetails(EmployeeDetailRequest  employeeDetailRequest){
        ApiResponse<EmployeeDetailRequest> response= manageEmployeeService.saveEmployeeDetails(employeeDetailRequest);
        return new ResponseEntity<>(response,response.getStatus());
    }

}
