package com.developer.coder.ems.mapper;

import com.developer.coder.ems.Entity.Employee;
import com.developer.coder.ems.dto.EmployeeDTO;

public class EmployeeMapper {
	public static EmployeeDTO mapToEmployeeDto(Employee employee) {
		return new EmployeeDTO(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	
	}

	public static Employee mapToEmployee(EmployeeDTO employeedto) {
		return new Employee(
			employeedto.getId(),
			employeedto.getFirstName(),
			employeedto.getLastName(),
			employeedto.getEmail()
	
				);
				
	}
}
