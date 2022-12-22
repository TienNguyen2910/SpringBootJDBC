package org.example.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DepartmentId")
    private int id;
    private String DepartmentName;

    public Department(int id, String departmentName) {
        this.id = id;
        this.DepartmentName = departmentName;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return DepartmentName;
    }

    public void setName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
}
