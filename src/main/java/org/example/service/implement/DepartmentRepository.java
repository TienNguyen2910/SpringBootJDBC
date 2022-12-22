package org.example.service.implement;

import org.example.model.Department;
import org.example.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.example.service.interfaces.IDepartment;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentRepository implements IDepartment {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Department> getAllDepartment() {
        return jdbcTemplate.query("select * from Department",(rs, rowNum) ->
            new Department(
                    rs.getInt("DepartmentId"),
                    rs.getString("DepartmentName"))
        );
    }

    @Override
    public ResponseObject getDepartmentById(int id) {
        try{
            Department department = jdbcTemplate.queryForObject("select * from Department where DepartmentId = ?",new Object[]{id},
                    (rs, rowNum) ->
                            new Department (
                                    rs.getInt("DepartmentId"),
                                    rs.getString("DepartmentName")
                            ));
            return new ResponseObject("Ok","Query department successfully",department);
        }catch(Exception ex){
            return new ResponseObject("false","Cannot find department with id = "+ id, "");
        }
    }

    @Override
    public int addDepartment(Department d) {
        return jdbcTemplate.update("insert into department(DepartmentName) values(?)",d.getName());
    }

    @Override
    public boolean deleteDepartment(int Id) {
        return false;
    }

}
