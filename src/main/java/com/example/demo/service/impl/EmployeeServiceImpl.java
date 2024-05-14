package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repositry.EmployeeRepositry;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepositry empRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
	
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list= empRepo.findAll();
		return list;
	}


	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		Employee existingId=empRepo.findById(updatedEmployee.getId()).get();
		existingId.setName(updatedEmployee.getName());
		existingId.setEmail(updatedEmployee.getEmail());
		
		return empRepo.save(existingId);
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		
		return empRepo.findById(id);
	}

	@Override
	public void deleteEmployee(long id) {
	
		empRepo.deleteById(id);
		
	}


}
