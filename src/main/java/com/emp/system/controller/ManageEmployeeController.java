package com.emp.system.controller;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeDetailRequest;
import com.emp.system.model.EmployeeDetailResponse;
import com.emp.system.model.ResignEmployeeRequest;
import com.emp.system.service.ManageEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee")
public class ManageEmployeeController {

    @Autowired
    ManageEmployeeService manageEmployeeService;

    @GetMapping(value="/getEmployee")
    public ResponseEntity<ApiResponse<EmployeeDetailResponse>> getEmployeeDetails(@RequestParam(required = false) String employeeId)throws CommonException {
        ApiResponse<EmployeeDetailResponse> response= manageEmployeeService.getEmployeeDetails(employeeId);
        return new ResponseEntity<>(response,response.getStatus());
    }
    @GetMapping(value="/getAllEmployee")
    public ResponseEntity<ApiResponse<List<EmployeeDetailResponse>>> getAllEmployeeDetails()throws CommonException {
        ApiResponse<List<EmployeeDetailResponse>> response= manageEmployeeService.getAllEmployeeDetails();
        return new ResponseEntity<>(response,response.getStatus());
    }

    @PutMapping(value="/updateEmployee")
    public ResponseEntity<ApiResponse<EmployeeDetailRequest>> updateEmployeeDetails(@RequestBody EmployeeDetailRequest employeeDetailRequest) throws CommonException{
        ApiResponse<EmployeeDetailRequest> response= manageEmployeeService.updateEmployeeDetails(employeeDetailRequest);
        return new ResponseEntity<>(response,response.getStatus());
    }
    @PostMapping(value="/saveEmployee")
    public ResponseEntity<ApiResponse<EmployeeDetailRequest>> saveEmployeeDetails(@RequestBody EmployeeDetailRequest  employeeDetailRequest){
        ApiResponse<EmployeeDetailRequest> response= manageEmployeeService.saveEmployeeDetails(employeeDetailRequest);
        return new ResponseEntity<>(response,response.getStatus());

    }
    @PutMapping(value="/resignEmployee")
    public ResponseEntity<ApiResponse<ResignEmployeeRequest>> resignEmployee(@RequestBody ResignEmployeeRequest resignEmployeeRequest) throws CommonException {
        ApiResponse<ResignEmployeeRequest> response = manageEmployeeService.resignEmployee(resignEmployeeRequest);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
