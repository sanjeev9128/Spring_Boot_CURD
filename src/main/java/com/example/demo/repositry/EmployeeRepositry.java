package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Long> {



}
