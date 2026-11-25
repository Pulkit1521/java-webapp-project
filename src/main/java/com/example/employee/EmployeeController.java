package com.example.employee;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    record Employee(int id, String name, String department, double salary) {}

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return List.of(
            new Employee(101, "Pulkit", "DevOps", 85000),
            new Employee(102, "Rahul", "Java Development", 95000),
            new Employee(103, "Priya", "Testing", 75000)
        );
    }

    @GetMapping("/health")
    public String health() {
        return "Employee Application is Running!";
    }
}
