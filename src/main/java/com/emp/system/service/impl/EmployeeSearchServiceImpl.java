package com.emp.system.service.impl;

import com.emp.system.exception.CommonException;
import com.emp.system.model.ApiResponse;
import com.emp.system.model.EmployeeSearchResultResponse;
import com.emp.system.service.EmployeeSearchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSearchServiceImpl implements EmployeeSearchService {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public ApiResponse<EmployeeSearchResultResponse> getEmployeeData
            (String searchType, String searchParam, Integer pageSize,
             Integer pageNumber, String sortBy, String sortIn, String fromDate, String toDate) throws CommonException {
//        ApiResponse<EmployeeSearchResultResponse> response=new ApiResponse<>();
//
//        pageSize = pageSize > 100 ? 40 : pageSize;
//        sortBy = sortBy != null && !sortBy.isEmpty() ? sortBy : "employeeName";
//        sortIn = sortIn != null && !sortIn.isEmpty() ? sortIn : "DESC";
//
//        String dataSelectQuery ="Select emp";
//        String dataCountQuery="Select count(1)";
//
//        StringBuilder queryString=new StringBuilder();
//        List<String> searchtypeList=List.of("mobileNumber","email","employeeName");
//        if(!(searchtypeList.contains(searchType))){
//            throw new CommonException("invalid parameter", HttpStatus.BAD_REQUEST);
//        }
//
//        queryString.append(" from EmployeeDetailsEntity emp where 1 = 1");
//        if ((null != searchType && !searchType.isEmpty()) && (null != searchParam && !searchParam.isEmpty())) {
//
//            if (searchType.equalsIgnoreCase("mobileNumber")) {
//                queryString.append("mobileNumber").append(" IN :searchParam")
//                        .append(" IN :searchParam )");
//            } else {
//                queryString.append(" and emp.").append(searchType).append(" IN :searchParam");
//            }
//        }
//
//        Query queryDataCount = entityManager.createQuery(dataCountQuery + queryString);
//        setAllParameters(searchParam, queryDataCount, customerIdList, fromDate, toDate, otfStatus, modelCd,
//                registrationType);
//
//

        return null;
    }

}
