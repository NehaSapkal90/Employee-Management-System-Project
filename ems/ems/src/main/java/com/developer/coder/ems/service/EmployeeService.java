package com.developer.coder.ems.service;

import java.util.List;

import com.developer.coder.ems.dto.EmployeeDTO;

public interface EmployeeService {
	
	
public EmployeeDTO createNewEmployee(EmployeeDTO employeedto);

public List<EmployeeDTO> getAllEmployees();

public EmployeeDTO getEmployeeById(Long id);

public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDto);;

public void deleteEmployeeById(Long id);
}
