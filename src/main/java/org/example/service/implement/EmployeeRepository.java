package org.example.service.implement;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.service.interfaces.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeRepository implements IEmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("select UserName,DateOfBirth,Email,Password, from employee",
                (rs, rowNum) ->
                new Employee(
                        rs.getString("UserName"),
                        rs.getDate("DateOfBirth"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        (Department) rs.getObject(2)));
    }
}
