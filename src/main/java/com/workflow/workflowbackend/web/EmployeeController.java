package com.workflow.workflowbackend.web;


import com.workflow.workflowbackend.model.Employee;
import com.workflow.workflowbackend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.createEmployee(employee);
        return employee1;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(employee.getId());
        return employee;
    }
}
