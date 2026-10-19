package com.workflow.workflowbackend.repository;

import com.workflow.workflowbackend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
