package com.workflow.workflowbackend.service;

import com.workflow.workflowbackend.model.Department;
import com.workflow.workflowbackend.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department "+id+" not found"));
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

}
