package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	@Autowired
	private EmployeeService empService;

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
		Employee saveEmp = empService.saveEmployee(emp);

		return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);

	}

	@GetMapping("getAll")
	public List<Employee> getAllEmp() {
		List<Employee> listEmp = empService.getAllEmployees();
		return listEmp;
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id) {

		Optional empId = empService.getEmployeeById(id);
		return empId;

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> UpdateEmployee(@PathVariable long id, @RequestBody Employee emp) {

		emp.setId(id);
		Employee empUpdate = empService.updateEmployee(emp);
		return new ResponseEntity<>(empUpdate, HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("delete successfully",HttpStatus.OK);
		
	}

}
