package com.workflow.workflowbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}

    public Employee(String firstName, String lastName, String email,
                    String phone, String position, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
