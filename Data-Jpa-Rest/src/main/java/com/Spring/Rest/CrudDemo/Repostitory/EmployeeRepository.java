package com.Spring.Rest.CrudDemo.Repostitory;

import com.Spring.Rest.CrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
