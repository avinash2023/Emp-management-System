package com.emp.system.service;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeSearchResultResponse;

public interface EmployeeSearchService {
    ApiResponse<EmployeeSearchResultResponse> getEmployeeData(String searchType, String searchParam, Integer pageSize,
                                                              Integer pageNumber, String sortBy, String sortIn,
                                                              String fromDate, String toDate) throws CommonException;
}
