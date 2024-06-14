package com.emp.system.repository;

import com.emp.system.entity.EmployeeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManageEmployeeRepository extends JpaRepository<EmployeeDetailsEntity, UUID> {
    public EmployeeDetailsEntity findByEmployeeId(UUID employeeId);
}
