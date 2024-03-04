package com.example.form.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@Column(name="id")
    int id;
    */
    @Column(name="employee_id")
    Integer employee_id;
    @Column(name="employee_name")
    String employee_name;
    @Column(name="phone_no")
    Long phone_no;
    @Column(name="email")
    String email;
    @Column(name="Department")
    String Department;

    public EmployeeDetails(String employee_name, long phone_no, String email, String department) {
       // this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.phone_no = phone_no;
        this.email = email;
        Department = department;
    }

    public EmployeeDetails() {
    }
/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    */

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Long phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                ", employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", phone_no=" + phone_no +
                ", email='" + email + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }
}
