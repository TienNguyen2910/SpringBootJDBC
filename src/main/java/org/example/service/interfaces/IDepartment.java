package org.example.service.interfaces;

import org.example.model.Department;
import org.example.model.ResponseObject;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IDepartment {
    public List<Department> getAllDepartment();
    public ResponseObject getDepartmentById(int Id);
    public int addDepartment(Department d);
    public boolean deleteDepartment(int Id);
}
