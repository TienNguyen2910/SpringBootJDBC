package org.example.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int EmployeeId;
    private String UserName;
    private Date DateOfBirth;
    private String Email;
    private String Password;
    @ManyToOne
    @JoinColumn(name = "DepartmentId")
    private Department department;

    public Employee(String userName, Date dateOfBirth, String email, String password, Department department) {
        UserName = userName;
        DateOfBirth = dateOfBirth;
        Email = email;
        Password = password;
        this.department = department;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
