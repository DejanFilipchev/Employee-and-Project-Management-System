package com.workflow.workflowbackend.repository;

import com.workflow.workflowbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
