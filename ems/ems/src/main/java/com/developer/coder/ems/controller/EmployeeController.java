package com.developer.coder.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.coder.ems.dto.EmployeeDTO;
import com.developer.coder.ems.service.EmployeeService;
import com.developer.coder.ems.service.EmployeeServiceEmp;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
//@AllArgsConstructor
public class EmployeeController {
	
	@Autowired
	private  EmployeeServiceEmp employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDto){
		EmployeeDTO savedEmployee = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDTO employeeByID= employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeByID, HttpStatus.OK);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable("id")Long employeeId, @RequestBody EmployeeDTO  employeeDto){
		EmployeeDTO employeeById= employeeService.updateEmployeeById(employeeId, employeeDto);
		return new ResponseEntity<>(employeeById, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<>("Employee record deleted sucessfully", HttpStatus.OK);
	}
	
	

	
	
}
