package com.workflow.workflowbackend.web;

import com.workflow.workflowbackend.model.Department;
import com.workflow.workflowbackend.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

}
