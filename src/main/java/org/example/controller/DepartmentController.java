package org.example.controller;

import org.example.model.ResponseObject;
import org.example.service.interfaces.IDepartment;
import org.example.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Departments")
public class DepartmentController {
    @Autowired
    private IDepartment iDepartment;
    @GetMapping("")
    //http://localhost:8080/api/Departments
    public List<Department> getAllDepartments(){
        return iDepartment.getAllDepartment();
    }

    //get department By id
    @GetMapping("/GetDepartmentById/{id}")
    //let's return an object
    public ResponseObject getDepartmentById(@PathVariable int id){
        ResponseObject department =iDepartment.getDepartmentById(id);
        if(department != null){
            return department;
        }else{
            return new ResponseObject("false","Cannot find department with id = "+ id, "");
        }
    }
    @PostMapping("/AddDepartment")
    public int addDepartment(@RequestBody Department d){
        return iDepartment.addDepartment(d);
    }
}
