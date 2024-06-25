package com.emp.system.controller;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeSearchResultResponse;
import com.emp.system.service.EmployeeSearchService;
import com.google.protobuf.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeSearchController {
    @Autowired
    EmployeeSearchService employeeSearchService;

    @GetMapping(value = "/search")
    public ResponseEntity<ApiResponse<EmployeeSearchResultResponse>> getEmployeeData(
            @RequestParam(required = false) String searchType,
            @RequestParam(required = false) String searchParam,
            @RequestParam(required = true) String pageSize,
            @RequestParam(required = true) String pageNumber,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortIn,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate
    ) throws CommonException {
        ApiResponse<EmployeeSearchResultResponse> response = employeeSearchService.getEmployeeData
                (searchType, searchParam, Integer.valueOf(pageSize), Integer.valueOf(pageNumber), sortBy, sortIn, fromDate, toDate);
        return new ResponseEntity<>(response,response.getStatus());
    }

}
