package com.workflow.workflowbackend.service;

import com.workflow.workflowbackend.model.Department;
import com.workflow.workflowbackend.model.Employee;
import com.workflow.workflowbackend.repository.DepartmentRepository;
import com.workflow.workflowbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee "+id+" not found." ));
        return employee;
    }

    public Employee createEmployee(Employee employee) {
        Long departmentId = employee.getDepartment().getId();
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department "+departmentId+" not found." ));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee "+ id +" not found"));
        employeeRepository.deleteById(employee.getId());
    }
}
