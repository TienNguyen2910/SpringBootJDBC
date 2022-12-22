package org.example.controller;

import org.example.model.Employee;
import org.example.service.interfaces.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Employees")
public class EmployeeController {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return iEmployeeRepository.getAllEmployees();
    }
}
